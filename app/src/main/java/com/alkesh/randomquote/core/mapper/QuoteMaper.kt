package com.alkesh.randomquote.core.mapper

import com.alkesh.randomquote.common.repo.QuoteRepository
import com.alkesh.randomquote.core.db.entity.DbQuote
import com.alkesh.randomquote.core.network.response.QuoteDto
import com.alkesh.randomquote.presentation.general.uiModel.UIQuoteModel

class QuoteMaper {
    fun convertDtoIntoUIModel(dto: QuoteDto?): UIQuoteModel? {
        var uiModel: UIQuoteModel? = null
        dto?.let {
            uiModel = UIQuoteModel(
                dto.id,
                dto.author,
                dto.quote,
                QuoteRepository.QuoteSource.Network.value
            )
        }
        return uiModel
    }

    fun convertDbModelIntoUIModel(dbModel: DbQuote?): UIQuoteModel? {
        var uiModel: UIQuoteModel? = null
        dbModel?.let {
            uiModel =
                UIQuoteModel(
                    dbModel.id,
                    dbModel.author,
                    dbModel.en,
                    QuoteRepository.QuoteSource.Database.value
                )
        }
        return uiModel
    }

    fun convertDtoIntoDbModel(dto: QuoteDto): DbQuote {
        return DbQuote(dto.id!!, dto.author, dto.quote)
    }
}