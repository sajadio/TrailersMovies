package com.sajjadio.trailers.data.paging


import com.sajjadio.trailers.data.base.BasePagingSource
import com.sajjadio.trailers.data.dataSource.model.movie.common.CommonDto
import com.sajjadio.trailers.data.dataSource.remote.MovieApiService
import com.sajjadio.trailers.domain.mapper.mapDtoToCommonResultMovieDomain
import com.sajjadio.trailers.domain.model.CommonResult
import retrofit2.Response

class ComingPagingSource(
    private val api: MovieApiService,
) : BasePagingSource<Int, CommonDto, CommonResult>() {

    override suspend fun apiCall(pageNumber: Int): Response<CommonDto> {
        return api.getUpComingMovie(page = pageNumber)
    }

    override fun mapperResponse(response: CommonDto?): List<CommonResult>? {
        return response?.results?.let {
            mapDtoToCommonResultMovieDomain(it)
        }
    }
}