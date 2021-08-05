package org.jellyfin.sample.compose

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import kotlinx.coroutines.flow.map
import org.jellyfin.sdk.Jellyfin
import org.jellyfin.sdk.model.ClientInfo
import org.jellyfin.sdk.model.DeviceInfo
import org.jellyfin.sdk.model.api.ServerDiscoveryInfo

fun main() = application {
	val jellyfin = Jellyfin {
		clientInfo = ClientInfo("Jellyfin Sample: Compose", "DEV")
		deviceInfo = DeviceInfo("compose", "compose")
	}
	val api = remember { jellyfin.createApi() }
	val serverInfo = remember { mutableStateOf<ServerDiscoveryInfo?>(null) }

	// temporary list collection hack
	val _servers = mutableListOf<ServerDiscoveryInfo>()
	val servers = jellyfin.discovery.discoverLocalServers().map { server ->
		_servers.add(server)
		_servers
	}.collectAsState(mutableListOf())

	Window(
		onCloseRequest = ::exitApplication,
		title = "Jellyfin Compose",
		state = rememberWindowState(width = 300.dp, height = 300.dp)
	) {
		DesktopMaterialTheme {
			if (serverInfo.value == null) {
				Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
					servers.value.forEach {
						Button(onClick = {
							api.baseUrl = it.address
							serverInfo.value = it
						}) {
							Column {
								Text(it.name ?: "Jellyfin")
								Text(it.address ?: "")
							}
						}
					}

					Row {
						val address = remember { mutableStateOf("") }
						TextField(address.value, { address.value = it }, maxLines = 1, label = {
							Text("Server address")
						})
						Button(onClick = {
							api.baseUrl = address.value
						}) {
							Text("Connect")
						}
					}
				}
			} else {
				Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
					Text(serverInfo.value?.name ?: "test")
				}
			}
		}
	}
}
