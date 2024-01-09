package com.soopeach.conviwizard

import com.soopeach.conviwizard.data.ConviWizardDataStore
import com.soopeach.conviwizard.data.datasource.AccountDatasource
import com.soopeach.conviwizard.data.datasource.AccountDatasourceImpl
import com.soopeach.conviwizard.data.datasource.PostDataSource
import com.soopeach.conviwizard.data.datasource.PostDataSourceImpl
import com.soopeach.conviwizard.data.repository.AccountRepositoryImpl
import com.soopeach.conviwizard.data.repository.PostRepositoryImpl
import com.soopeach.conviwizard.domain.repository.AccountRepository
import com.soopeach.conviwizard.domain.repository.PostRepository
import com.soopeach.conviwizard.domain.usecase.GetPostsUseCase
import com.soopeach.conviwizard.domain.usecase.GetUidUseCase
import com.soopeach.conviwizard.domain.usecase.PostSignUpUseCase
import com.soopeach.conviwizard.domain.usecase.RequestLoginUseCase
import com.soopeach.conviwizard.domain.usecase.UpdateUidUseCase
import com.soopeach.conviwizard.viewmodel.CheckScreenViewModel
import com.soopeach.conviwizard.viewmodel.HomeScreenViewModel
import com.soopeach.conviwizard.viewmodel.LoginScreenViewModel
import com.soopeach.conviwizard.viewmodel.SignUpScreenViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val viewModelModule = module {
    single { CheckScreenViewModel(get()) }
    single { SignUpScreenViewModel(get()) }
    single { LoginScreenViewModel(get(), get()) }
    single { HomeScreenViewModel(get()) }
}

val useCaseModule = module {
    single { GetUidUseCase(get()) }
    single { PostSignUpUseCase(get()) }
    single { RequestLoginUseCase(get()) }
    single { UpdateUidUseCase(get()) }
    single { GetPostsUseCase(get()) }
}

val repositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl(get()) }
    single<PostRepository> { PostRepositoryImpl(get()) }
}

val dataSourceModule = module {
    single<AccountDatasource> { AccountDatasourceImpl(get(), get()) }
    single<PostDataSource> { PostDataSourceImpl(get(), get()) }
}

val databaseModule = module {
    single<ConviWizardDataStore> { ConviWizardDataStore(get()) }
}

val networkModule = module {

    single<HttpClient> {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
            install(HttpCookies)
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL

            }
            defaultRequest {
                url("http://ec2-43-201-12-132.ap-northeast-2.compute.amazonaws.com:8080/")
            }
        }
    }
}
