package com.alkesh.randomquote.common.repo

import com.alkesh.randomquote.common.base.BaseRepository
import com.alkesh.randomquote.core.db.entity.DbQuote
import com.alkesh.randomquote.core.mapper.QuoteMaper
import com.alkesh.randomquote.presentation.general.uiModel.UIQuoteModel
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class QuoteRepository @Inject constructor(): BaseRepository() {
    private val quoteMapper = QuoteMaper()

    suspend fun getRandomQuote(): UIQuoteModel? {
        val uiModel: UIQuoteModel?
        uiModel = try {
            val response = retrofit.getRandomQuote()
            if (response.isSuccessful) {
                val dto = response.body()
                dto?.let {
                    val dbModel = quoteMapper.convertDtoIntoDbModel(dto)
                    saveIntoDb(dbModel)
                }
                quoteMapper.convertDtoIntoUIModel(dto)
            } else {
                quoteMapper.convertDbModelIntoUIModel(getRandomModelFromDb())
            }
        } catch (exp: Exception) {
            quoteMapper.convertDbModelIntoUIModel(getRandomModelFromDb())
        }
        return uiModel
    }

    private suspend fun saveIntoDb(model: DbQuote) {
        dbInstance?.quoteDao()?.insertAll(model)
    }


    private suspend fun getRandomModelFromDb(): DbQuote? {
        var dbQuote: DbQuote? = null
        dbInstance?.quoteDao()?.let {
            val listDbQuotes = it.getAll()
            if (!listDbQuotes.isNullOrEmpty()) {
                val num = Random.nextInt(0, listDbQuotes.size - 1)
                dbQuote = listDbQuotes[num]
            }
        }
        return dbQuote
    }


    enum class QuoteSource(var value: String) {
        Network("API"),
        Database("Database")
    }
}