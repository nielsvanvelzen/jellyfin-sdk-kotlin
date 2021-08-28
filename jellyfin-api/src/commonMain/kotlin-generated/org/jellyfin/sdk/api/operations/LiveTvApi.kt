// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.api.operations

import io.ktor.utils.io.ByteReadChannel
import kotlin.Any
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.Collection
import kotlin.collections.List
import kotlin.collections.emptyList
import kotlin.collections.emptyMap
import kotlin.collections.mutableMapOf
import org.jellyfin.sdk.api.client.ApiClient
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.api.client.extensions.`get`
import org.jellyfin.sdk.api.client.extensions.delete
import org.jellyfin.sdk.api.client.extensions.post
import org.jellyfin.sdk.model.DateTime
import org.jellyfin.sdk.model.UUID
import org.jellyfin.sdk.model.api.BaseItemDto
import org.jellyfin.sdk.model.api.BaseItemDtoQueryResult
import org.jellyfin.sdk.model.api.ChannelMappingOptionsDto
import org.jellyfin.sdk.model.api.ChannelType
import org.jellyfin.sdk.model.api.GetProgramsDto
import org.jellyfin.sdk.model.api.GuideInfo
import org.jellyfin.sdk.model.api.ImageType
import org.jellyfin.sdk.model.api.ItemFields
import org.jellyfin.sdk.model.api.ListingsProviderInfo
import org.jellyfin.sdk.model.api.LiveTvInfo
import org.jellyfin.sdk.model.api.NameIdPair
import org.jellyfin.sdk.model.api.RecordingStatus
import org.jellyfin.sdk.model.api.SeriesTimerInfoDto
import org.jellyfin.sdk.model.api.SeriesTimerInfoDtoQueryResult
import org.jellyfin.sdk.model.api.SetChannelMappingDto
import org.jellyfin.sdk.model.api.SortOrder
import org.jellyfin.sdk.model.api.TimerInfoDto
import org.jellyfin.sdk.model.api.TimerInfoDtoQueryResult
import org.jellyfin.sdk.model.api.TunerChannelMapping
import org.jellyfin.sdk.model.api.TunerHostInfo

public class LiveTvApi(
	private val api: ApiClient
) {
	/**
	 * Adds a listings provider.
	 *
	 * @param pw Password.
	 * @param validateListings Validate listings.
	 * @param validateLogin Validate login.
	 */
	public suspend fun addListingProvider(
		pw: String? = null,
		validateListings: Boolean? = false,
		validateLogin: Boolean? = false,
		`data`: ListingsProviderInfo? = null
	): Response<ListingsProviderInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["pw"] = pw
		queryParameters["validateListings"] = validateListings
		queryParameters["validateLogin"] = validateLogin
		val response = api.post<ListingsProviderInfo>("/LiveTv/ListingProviders", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Adds a tuner host.
	 */
	public suspend fun addTunerHost(`data`: TunerHostInfo? = null): Response<TunerHostInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<TunerHostInfo>("/LiveTv/TunerHosts", pathParameters, queryParameters,
				data)
		return response
	}

	/**
	 * Cancels a live tv series timer.
	 *
	 * @param timerId Timer id.
	 */
	public suspend fun cancelSeriesTimer(timerId: String): Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["timerId"] = timerId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.delete<Unit>("/LiveTv/SeriesTimers/{timerId}", pathParameters, queryParameters,
				data)
		return response
	}

	/**
	 * Cancels a live tv timer.
	 *
	 * @param timerId Timer id.
	 */
	public suspend fun cancelTimer(timerId: String): Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["timerId"] = timerId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.delete<Unit>("/LiveTv/Timers/{timerId}", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Creates a live tv series timer.
	 */
	public suspend fun createSeriesTimer(`data`: SeriesTimerInfoDto? = null): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<Unit>("/LiveTv/SeriesTimers", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Creates a live tv timer.
	 */
	public suspend fun createTimer(`data`: TimerInfoDto? = null): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<Unit>("/LiveTv/Timers", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Delete listing provider.
	 *
	 * @param id Listing provider id.
	 */
	public suspend fun deleteListingProvider(id: String? = null): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		val data = null
		val response = api.delete<Unit>("/LiveTv/ListingProviders", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Deletes a live tv recording.
	 *
	 * @param recordingId Recording id.
	 */
	public suspend fun deleteRecording(recordingId: UUID): Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["recordingId"] = recordingId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.delete<Unit>("/LiveTv/Recordings/{recordingId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Deletes a tuner host.
	 *
	 * @param id Tuner host id.
	 */
	public suspend fun deleteTunerHost(id: String? = null): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		val data = null
		val response = api.delete<Unit>("/LiveTv/TunerHosts", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Discover tuners.
	 *
	 * @param newDevicesOnly Only discover new tuners.
	 */
	public suspend fun discoverTuners(newDevicesOnly: Boolean? = false):
			Response<List<TunerHostInfo>> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["newDevicesOnly"] = newDevicesOnly
		val data = null
		val response = api.`get`<List<TunerHostInfo>>("/LiveTv/Tuners/Discover", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Discover tuners.
	 *
	 * @param newDevicesOnly Only discover new tuners.
	 */
	public suspend fun discvoverTuners(newDevicesOnly: Boolean? = false):
			Response<List<TunerHostInfo>> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["newDevicesOnly"] = newDevicesOnly
		val data = null
		val response = api.`get`<List<TunerHostInfo>>("/LiveTv/Tuners/Discvover", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets a live tv channel.
	 *
	 * @param channelId Channel id.
	 * @param userId Optional. Attach user data.
	 */
	public suspend fun getChannel(channelId: UUID, userId: UUID? = null): Response<BaseItemDto> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["channelId"] = channelId
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["userId"] = userId
		val data = null
		val response = api.`get`<BaseItemDto>("/LiveTv/Channels/{channelId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Get channel mapping options.
	 *
	 * @param providerId Provider id.
	 */
	public suspend fun getChannelMappingOptions(providerId: String? = null):
			Response<ChannelMappingOptionsDto> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["providerId"] = providerId
		val data = null
		val response = api.`get`<ChannelMappingOptionsDto>("/LiveTv/ChannelMappingOptions",
				pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets default listings provider info.
	 */
	public suspend fun getDefaultListingProvider(): Response<ListingsProviderInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<ListingsProviderInfo>("/LiveTv/ListingProviders/Default", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets the default values for a new timer.
	 *
	 * @param programId Optional. To attach default values based on a program.
	 */
	public suspend fun getDefaultTimer(programId: String? = null): Response<SeriesTimerInfoDto> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["programId"] = programId
		val data = null
		val response = api.`get`<SeriesTimerInfoDto>("/LiveTv/Timers/Defaults", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Get guid info.
	 */
	public suspend fun getGuideInfo(): Response<GuideInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<GuideInfo>("/LiveTv/GuideInfo", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets available lineups.
	 *
	 * @param id Provider id.
	 * @param type Provider type.
	 * @param location Location.
	 * @param country Country.
	 */
	public suspend fun getLineups(
		id: String? = null,
		type: String? = null,
		location: String? = null,
		country: String? = null
	): Response<List<NameIdPair>> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		queryParameters["type"] = type
		queryParameters["location"] = location
		queryParameters["country"] = country
		val data = null
		val response = api.`get`<List<NameIdPair>>("/LiveTv/ListingProviders/Lineups", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets a live tv recording stream.
	 *
	 * @param recordingId Recording id.
	 */
	public suspend fun getLiveRecordingFile(recordingId: String): Response<ByteReadChannel> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["recordingId"] = recordingId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<ByteReadChannel>("/LiveTv/LiveRecordings/{recordingId}/stream",
				pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets a live tv recording stream.
	 *
	 * @param recordingId Recording id.
	 * @param includeCredentials Add the access token to the url to make an authenticated request.
	 */
	public fun getLiveRecordingFileUrl(recordingId: String, includeCredentials: Boolean = false):
			String {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["recordingId"] = recordingId
		val queryParameters = emptyMap<String, Any?>()
		return api.createUrl("/LiveTv/LiveRecordings/{recordingId}/stream", pathParameters,
				queryParameters, includeCredentials)
	}

	/**
	 * Gets a live tv channel stream.
	 *
	 * @param streamId Stream id.
	 * @param container Container type.
	 */
	public suspend fun getLiveStreamFile(streamId: String, container: String):
			Response<ByteReadChannel> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["streamId"] = streamId
		pathParameters["container"] = container
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<ByteReadChannel>("/LiveTv/LiveStreamFiles/{streamId}/stream.{container}",
				pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets a live tv channel stream.
	 *
	 * @param streamId Stream id.
	 * @param container Container type.
	 * @param includeCredentials Add the access token to the url to make an authenticated request.
	 */
	public fun getLiveStreamFileUrl(
		streamId: String,
		container: String,
		includeCredentials: Boolean = false
	): String {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["streamId"] = streamId
		pathParameters["container"] = container
		val queryParameters = emptyMap<String, Any?>()
		return api.createUrl("/LiveTv/LiveStreamFiles/{streamId}/stream.{container}", pathParameters,
				queryParameters, includeCredentials)
	}

	/**
	 * Gets available live tv channels.
	 *
	 * @param type Optional. Filter by channel type.
	 * @param userId Optional. Filter by user and attach user data.
	 * @param startIndex Optional. The record index to start at. All items with a lower index will be
	 * dropped from the results.
	 * @param isMovie Optional. Filter for movies.
	 * @param isSeries Optional. Filter for series.
	 * @param isNews Optional. Filter for news.
	 * @param isKids Optional. Filter for kids.
	 * @param isSports Optional. Filter for sports.
	 * @param limit Optional. The maximum number of records to return.
	 * @param isFavorite Optional. Filter by channels that are favorites, or not.
	 * @param isLiked Optional. Filter by channels that are liked, or not.
	 * @param isDisliked Optional. Filter by channels that are disliked, or not.
	 * @param enableImages Optional. Include image information in output.
	 * @param imageTypeLimit Optional. The max number of images to return, per image type.
	 * @param enableImageTypes "Optional. The image types to include in the output.
	 * @param fields Optional. Specify additional fields of information to return in the output.
	 * @param enableUserData Optional. Include user data.
	 * @param sortBy Optional. Key to sort by.
	 * @param sortOrder Optional. Sort order.
	 * @param enableFavoriteSorting Optional. Incorporate favorite and like status into channel
	 * sorting.
	 * @param addCurrentProgram Optional. Adds current program info to each channel.
	 */
	public suspend fun getLiveTvChannels(
		type: ChannelType? = null,
		userId: UUID? = null,
		startIndex: Int? = null,
		isMovie: Boolean? = null,
		isSeries: Boolean? = null,
		isNews: Boolean? = null,
		isKids: Boolean? = null,
		isSports: Boolean? = null,
		limit: Int? = null,
		isFavorite: Boolean? = null,
		isLiked: Boolean? = null,
		isDisliked: Boolean? = null,
		enableImages: Boolean? = null,
		imageTypeLimit: Int? = null,
		enableImageTypes: Collection<ImageType>? = emptyList(),
		fields: Collection<ItemFields>? = emptyList(),
		enableUserData: Boolean? = null,
		sortBy: Collection<String>? = emptyList(),
		sortOrder: SortOrder? = null,
		enableFavoriteSorting: Boolean? = false,
		addCurrentProgram: Boolean? = true
	): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["type"] = type
		queryParameters["userId"] = userId
		queryParameters["startIndex"] = startIndex
		queryParameters["isMovie"] = isMovie
		queryParameters["isSeries"] = isSeries
		queryParameters["isNews"] = isNews
		queryParameters["isKids"] = isKids
		queryParameters["isSports"] = isSports
		queryParameters["limit"] = limit
		queryParameters["isFavorite"] = isFavorite
		queryParameters["isLiked"] = isLiked
		queryParameters["isDisliked"] = isDisliked
		queryParameters["enableImages"] = enableImages
		queryParameters["imageTypeLimit"] = imageTypeLimit
		queryParameters["enableImageTypes"] = enableImageTypes
		queryParameters["fields"] = fields
		queryParameters["enableUserData"] = enableUserData
		queryParameters["sortBy"] = sortBy
		queryParameters["sortOrder"] = sortOrder
		queryParameters["enableFavoriteSorting"] = enableFavoriteSorting
		queryParameters["addCurrentProgram"] = addCurrentProgram
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Channels", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets available live tv services.
	 */
	public suspend fun getLiveTvInfo(): Response<LiveTvInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<LiveTvInfo>("/LiveTv/Info", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets available live tv epgs.
	 *
	 * @param channelIds The channels to return guide information for.
	 * @param userId Optional. Filter by user id.
	 * @param minStartDate Optional. The minimum premiere start date.
	 * @param hasAired Optional. Filter by programs that have completed airing, or not.
	 * @param isAiring Optional. Filter by programs that are currently airing, or not.
	 * @param maxStartDate Optional. The maximum premiere start date.
	 * @param minEndDate Optional. The minimum premiere end date.
	 * @param maxEndDate Optional. The maximum premiere end date.
	 * @param isMovie Optional. Filter for movies.
	 * @param isSeries Optional. Filter for series.
	 * @param isNews Optional. Filter for news.
	 * @param isKids Optional. Filter for kids.
	 * @param isSports Optional. Filter for sports.
	 * @param startIndex Optional. The record index to start at. All items with a lower index will be
	 * dropped from the results.
	 * @param limit Optional. The maximum number of records to return.
	 * @param sortBy Optional. Specify one or more sort orders, comma delimited. Options: Name,
	 * StartDate.
	 * @param sortOrder Sort Order - Ascending,Descending.
	 * @param genres The genres to return guide information for.
	 * @param genreIds The genre ids to return guide information for.
	 * @param enableImages Optional. Include image information in output.
	 * @param imageTypeLimit Optional. The max number of images to return, per image type.
	 * @param enableImageTypes Optional. The image types to include in the output.
	 * @param enableUserData Optional. Include user data.
	 * @param seriesTimerId Optional. Filter by series timer id.
	 * @param librarySeriesId Optional. Filter by library series id.
	 * @param fields Optional. Specify additional fields of information to return in the output.
	 * @param enableTotalRecordCount Retrieve total record count.
	 */
	public suspend fun getLiveTvPrograms(
		channelIds: Collection<UUID>? = emptyList(),
		userId: UUID? = null,
		minStartDate: DateTime? = null,
		hasAired: Boolean? = null,
		isAiring: Boolean? = null,
		maxStartDate: DateTime? = null,
		minEndDate: DateTime? = null,
		maxEndDate: DateTime? = null,
		isMovie: Boolean? = null,
		isSeries: Boolean? = null,
		isNews: Boolean? = null,
		isKids: Boolean? = null,
		isSports: Boolean? = null,
		startIndex: Int? = null,
		limit: Int? = null,
		sortBy: Collection<String>? = emptyList(),
		sortOrder: Collection<SortOrder>? = emptyList(),
		genres: Collection<String>? = emptyList(),
		genreIds: Collection<UUID>? = emptyList(),
		enableImages: Boolean? = null,
		imageTypeLimit: Int? = null,
		enableImageTypes: Collection<ImageType>? = emptyList(),
		enableUserData: Boolean? = null,
		seriesTimerId: String? = null,
		librarySeriesId: UUID? = null,
		fields: Collection<ItemFields>? = emptyList(),
		enableTotalRecordCount: Boolean? = true
	): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["channelIds"] = channelIds
		queryParameters["userId"] = userId
		queryParameters["minStartDate"] = minStartDate
		queryParameters["hasAired"] = hasAired
		queryParameters["isAiring"] = isAiring
		queryParameters["maxStartDate"] = maxStartDate
		queryParameters["minEndDate"] = minEndDate
		queryParameters["maxEndDate"] = maxEndDate
		queryParameters["isMovie"] = isMovie
		queryParameters["isSeries"] = isSeries
		queryParameters["isNews"] = isNews
		queryParameters["isKids"] = isKids
		queryParameters["isSports"] = isSports
		queryParameters["startIndex"] = startIndex
		queryParameters["limit"] = limit
		queryParameters["sortBy"] = sortBy
		queryParameters["sortOrder"] = sortOrder
		queryParameters["genres"] = genres
		queryParameters["genreIds"] = genreIds
		queryParameters["enableImages"] = enableImages
		queryParameters["imageTypeLimit"] = imageTypeLimit
		queryParameters["enableImageTypes"] = enableImageTypes
		queryParameters["enableUserData"] = enableUserData
		queryParameters["seriesTimerId"] = seriesTimerId
		queryParameters["librarySeriesId"] = librarySeriesId
		queryParameters["fields"] = fields
		queryParameters["enableTotalRecordCount"] = enableTotalRecordCount
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Programs", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets a live tv program.
	 *
	 * @param programId Program id.
	 * @param userId Optional. Attach user data.
	 */
	public suspend fun getProgram(programId: String, userId: UUID? = null): Response<BaseItemDto> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["programId"] = programId
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["userId"] = userId
		val data = null
		val response = api.`get`<BaseItemDto>("/LiveTv/Programs/{programId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets available live tv epgs.
	 */
	public suspend fun getPrograms(`data`: GetProgramsDto? = null): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<BaseItemDtoQueryResult>("/LiveTv/Programs", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets recommended live tv epgs.
	 *
	 * @param userId Optional. filter by user id.
	 * @param limit Optional. The maximum number of records to return.
	 * @param isAiring Optional. Filter by programs that are currently airing, or not.
	 * @param hasAired Optional. Filter by programs that have completed airing, or not.
	 * @param isSeries Optional. Filter for series.
	 * @param isMovie Optional. Filter for movies.
	 * @param isNews Optional. Filter for news.
	 * @param isKids Optional. Filter for kids.
	 * @param isSports Optional. Filter for sports.
	 * @param enableImages Optional. Include image information in output.
	 * @param imageTypeLimit Optional. The max number of images to return, per image type.
	 * @param enableImageTypes Optional. The image types to include in the output.
	 * @param genreIds The genres to return guide information for.
	 * @param fields Optional. Specify additional fields of information to return in the output.
	 * @param enableUserData Optional. include user data.
	 * @param enableTotalRecordCount Retrieve total record count.
	 */
	public suspend fun getRecommendedPrograms(
		userId: UUID? = null,
		limit: Int? = null,
		isAiring: Boolean? = null,
		hasAired: Boolean? = null,
		isSeries: Boolean? = null,
		isMovie: Boolean? = null,
		isNews: Boolean? = null,
		isKids: Boolean? = null,
		isSports: Boolean? = null,
		enableImages: Boolean? = null,
		imageTypeLimit: Int? = null,
		enableImageTypes: Collection<ImageType>? = emptyList(),
		genreIds: Collection<UUID>? = emptyList(),
		fields: Collection<ItemFields>? = emptyList(),
		enableUserData: Boolean? = null,
		enableTotalRecordCount: Boolean? = true
	): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["userId"] = userId
		queryParameters["limit"] = limit
		queryParameters["isAiring"] = isAiring
		queryParameters["hasAired"] = hasAired
		queryParameters["isSeries"] = isSeries
		queryParameters["isMovie"] = isMovie
		queryParameters["isNews"] = isNews
		queryParameters["isKids"] = isKids
		queryParameters["isSports"] = isSports
		queryParameters["enableImages"] = enableImages
		queryParameters["imageTypeLimit"] = imageTypeLimit
		queryParameters["enableImageTypes"] = enableImageTypes
		queryParameters["genreIds"] = genreIds
		queryParameters["fields"] = fields
		queryParameters["enableUserData"] = enableUserData
		queryParameters["enableTotalRecordCount"] = enableTotalRecordCount
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Programs/Recommended", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets a live tv recording.
	 *
	 * @param recordingId Recording id.
	 * @param userId Optional. Attach user data.
	 */
	public suspend fun getRecording(recordingId: UUID, userId: UUID? = null): Response<BaseItemDto> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["recordingId"] = recordingId
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["userId"] = userId
		val data = null
		val response = api.`get`<BaseItemDto>("/LiveTv/Recordings/{recordingId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets recording folders.
	 *
	 * @param userId Optional. Filter by user and attach user data.
	 */
	public suspend fun getRecordingFolders(userId: UUID? = null): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["userId"] = userId
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Recordings/Folders", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Get recording group.
	 *
	 * @param groupId Group id.
	 */
	@Deprecated("This member is deprecated and may be removed in the future")
	public suspend fun getRecordingGroup(groupId: UUID): Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["groupId"] = groupId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<Unit>("/LiveTv/Recordings/Groups/{groupId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets live tv recording groups.
	 *
	 * @param userId Optional. Filter by user and attach user data.
	 */
	@Deprecated("This member is deprecated and may be removed in the future")
	public suspend fun getRecordingGroups(userId: UUID? = null): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["userId"] = userId
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Recordings/Groups", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets live tv recordings.
	 *
	 * @param channelId Optional. Filter by channel id.
	 * @param userId Optional. Filter by user and attach user data.
	 * @param startIndex Optional. The record index to start at. All items with a lower index will be
	 * dropped from the results.
	 * @param limit Optional. The maximum number of records to return.
	 * @param status Optional. Filter by recording status.
	 * @param isInProgress Optional. Filter by recordings that are in progress, or not.
	 * @param seriesTimerId Optional. Filter by recordings belonging to a series timer.
	 * @param enableImages Optional. Include image information in output.
	 * @param imageTypeLimit Optional. The max number of images to return, per image type.
	 * @param enableImageTypes Optional. The image types to include in the output.
	 * @param fields Optional. Specify additional fields of information to return in the output.
	 * @param enableUserData Optional. Include user data.
	 * @param isMovie Optional. Filter for movies.
	 * @param isSeries Optional. Filter for series.
	 * @param isKids Optional. Filter for kids.
	 * @param isSports Optional. Filter for sports.
	 * @param isNews Optional. Filter for news.
	 * @param isLibraryItem Optional. Filter for is library item.
	 * @param enableTotalRecordCount Optional. Return total record count.
	 */
	public suspend fun getRecordings(
		channelId: String? = null,
		userId: UUID? = null,
		startIndex: Int? = null,
		limit: Int? = null,
		status: RecordingStatus? = null,
		isInProgress: Boolean? = null,
		seriesTimerId: String? = null,
		enableImages: Boolean? = null,
		imageTypeLimit: Int? = null,
		enableImageTypes: Collection<ImageType>? = emptyList(),
		fields: Collection<ItemFields>? = emptyList(),
		enableUserData: Boolean? = null,
		isMovie: Boolean? = null,
		isSeries: Boolean? = null,
		isKids: Boolean? = null,
		isSports: Boolean? = null,
		isNews: Boolean? = null,
		isLibraryItem: Boolean? = null,
		enableTotalRecordCount: Boolean? = true
	): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["channelId"] = channelId
		queryParameters["userId"] = userId
		queryParameters["startIndex"] = startIndex
		queryParameters["limit"] = limit
		queryParameters["status"] = status
		queryParameters["isInProgress"] = isInProgress
		queryParameters["seriesTimerId"] = seriesTimerId
		queryParameters["enableImages"] = enableImages
		queryParameters["imageTypeLimit"] = imageTypeLimit
		queryParameters["enableImageTypes"] = enableImageTypes
		queryParameters["fields"] = fields
		queryParameters["enableUserData"] = enableUserData
		queryParameters["isMovie"] = isMovie
		queryParameters["isSeries"] = isSeries
		queryParameters["isKids"] = isKids
		queryParameters["isSports"] = isSports
		queryParameters["isNews"] = isNews
		queryParameters["isLibraryItem"] = isLibraryItem
		queryParameters["enableTotalRecordCount"] = enableTotalRecordCount
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Recordings", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets live tv recording series.
	 *
	 * @param channelId Optional. Filter by channel id.
	 * @param userId Optional. Filter by user and attach user data.
	 * @param groupId Optional. Filter by recording group.
	 * @param startIndex Optional. The record index to start at. All items with a lower index will be
	 * dropped from the results.
	 * @param limit Optional. The maximum number of records to return.
	 * @param status Optional. Filter by recording status.
	 * @param isInProgress Optional. Filter by recordings that are in progress, or not.
	 * @param seriesTimerId Optional. Filter by recordings belonging to a series timer.
	 * @param enableImages Optional. Include image information in output.
	 * @param imageTypeLimit Optional. The max number of images to return, per image type.
	 * @param enableImageTypes Optional. The image types to include in the output.
	 * @param fields Optional. Specify additional fields of information to return in the output.
	 * @param enableUserData Optional. Include user data.
	 * @param enableTotalRecordCount Optional. Return total record count.
	 */
	@Deprecated("This member is deprecated and may be removed in the future")
	public suspend fun getRecordingsSeries(
		channelId: String? = null,
		userId: UUID? = null,
		groupId: String? = null,
		startIndex: Int? = null,
		limit: Int? = null,
		status: RecordingStatus? = null,
		isInProgress: Boolean? = null,
		seriesTimerId: String? = null,
		enableImages: Boolean? = null,
		imageTypeLimit: Int? = null,
		enableImageTypes: Collection<ImageType>? = emptyList(),
		fields: Collection<ItemFields>? = emptyList(),
		enableUserData: Boolean? = null,
		enableTotalRecordCount: Boolean? = true
	): Response<BaseItemDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["channelId"] = channelId
		queryParameters["userId"] = userId
		queryParameters["groupId"] = groupId
		queryParameters["startIndex"] = startIndex
		queryParameters["limit"] = limit
		queryParameters["status"] = status
		queryParameters["isInProgress"] = isInProgress
		queryParameters["seriesTimerId"] = seriesTimerId
		queryParameters["enableImages"] = enableImages
		queryParameters["imageTypeLimit"] = imageTypeLimit
		queryParameters["enableImageTypes"] = enableImageTypes
		queryParameters["fields"] = fields
		queryParameters["enableUserData"] = enableUserData
		queryParameters["enableTotalRecordCount"] = enableTotalRecordCount
		val data = null
		val response = api.`get`<BaseItemDtoQueryResult>("/LiveTv/Recordings/Series", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets available countries.
	 */
	public suspend fun getSchedulesDirectCountries(): Response<ByteReadChannel> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<ByteReadChannel>("/LiveTv/ListingProviders/SchedulesDirect/Countries",
				pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Gets available countries.
	 *
	 * @param includeCredentials Add the access token to the url to make an authenticated request.
	 */
	public fun getSchedulesDirectCountriesUrl(includeCredentials: Boolean = true): String {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		return api.createUrl("/LiveTv/ListingProviders/SchedulesDirect/Countries", pathParameters,
				queryParameters, includeCredentials)
	}

	/**
	 * Gets a live tv series timer.
	 *
	 * @param timerId Timer id.
	 */
	public suspend fun getSeriesTimer(timerId: String): Response<SeriesTimerInfoDto> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["timerId"] = timerId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<SeriesTimerInfoDto>("/LiveTv/SeriesTimers/{timerId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets live tv series timers.
	 *
	 * @param sortBy Optional. Sort by SortName or Priority.
	 * @param sortOrder Optional. Sort in Ascending or Descending order.
	 */
	public suspend fun getSeriesTimers(sortBy: String? = null, sortOrder: SortOrder? = null):
			Response<SeriesTimerInfoDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["sortBy"] = sortBy
		queryParameters["sortOrder"] = sortOrder
		val data = null
		val response = api.`get`<SeriesTimerInfoDtoQueryResult>("/LiveTv/SeriesTimers", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets a timer.
	 *
	 * @param timerId Timer id.
	 */
	public suspend fun getTimer(timerId: String): Response<TimerInfoDto> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["timerId"] = timerId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<TimerInfoDto>("/LiveTv/Timers/{timerId}", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Gets the live tv timers.
	 *
	 * @param channelId Optional. Filter by channel id.
	 * @param seriesTimerId Optional. Filter by timers belonging to a series timer.
	 * @param isActive Optional. Filter by timers that are active.
	 * @param isScheduled Optional. Filter by timers that are scheduled.
	 */
	public suspend fun getTimers(
		channelId: String? = null,
		seriesTimerId: String? = null,
		isActive: Boolean? = null,
		isScheduled: Boolean? = null
	): Response<TimerInfoDtoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["channelId"] = channelId
		queryParameters["seriesTimerId"] = seriesTimerId
		queryParameters["isActive"] = isActive
		queryParameters["isScheduled"] = isScheduled
		val data = null
		val response = api.`get`<TimerInfoDtoQueryResult>("/LiveTv/Timers", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Get tuner host types.
	 */
	public suspend fun getTunerHostTypes(): Response<List<NameIdPair>> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.`get`<List<NameIdPair>>("/LiveTv/TunerHosts/Types", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Resets a tv tuner.
	 *
	 * @param tunerId Tuner id.
	 */
	public suspend fun resetTuner(tunerId: String): Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["tunerId"] = tunerId
		val queryParameters = emptyMap<String, Any?>()
		val data = null
		val response = api.post<Unit>("/LiveTv/Tuners/{tunerId}/Reset", pathParameters, queryParameters,
				data)
		return response
	}

	/**
	 * Set channel mappings.
	 */
	public suspend fun setChannelMapping(`data`: SetChannelMappingDto): Response<TunerChannelMapping> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<TunerChannelMapping>("/LiveTv/ChannelMappings", pathParameters,
				queryParameters, data)
		return response
	}

	/**
	 * Updates a live tv series timer.
	 *
	 * @param timerId Timer id.
	 */
	public suspend fun updateSeriesTimer(timerId: String, `data`: SeriesTimerInfoDto? = null):
			Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["timerId"] = timerId
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<Unit>("/LiveTv/SeriesTimers/{timerId}", pathParameters, queryParameters,
				data)
		return response
	}

	/**
	 * Updates a live tv timer.
	 *
	 * @param timerId Timer id.
	 */
	public suspend fun updateTimer(timerId: String, `data`: TimerInfoDto? = null): Response<Unit> {
		val pathParameters = mutableMapOf<String, Any?>()
		pathParameters["timerId"] = timerId
		val queryParameters = emptyMap<String, Any?>()
		val response = api.post<Unit>("/LiveTv/Timers/{timerId}", pathParameters, queryParameters, data)
		return response
	}
}
