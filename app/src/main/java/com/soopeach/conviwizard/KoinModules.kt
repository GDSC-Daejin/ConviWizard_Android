package com.soopeach.conviwizard

import com.soopeach.conviwizard.data.ConviWizardDataStore
import com.soopeach.conviwizard.data.datasource.AccountDatasource
import com.soopeach.conviwizard.data.datasource.AccountDatasourceImpl
import com.soopeach.conviwizard.data.repository.AccountRepositoryImpl
import com.soopeach.conviwizard.domain.repository.AccountRepository
import com.soopeach.conviwizard.domain.usecase.GetUidUseCase
import com.soopeach.conviwizard.viewmodel.CheckScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { CheckScreenViewModel(get())  }
}

val useCaseModule = module {
    single { GetUidUseCase(get()) }
}

val repositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl(get()) }
}

val dataSourceModule = module {
    single<AccountDatasource> { AccountDatasourceImpl(get()) }
}

val databaseModule = module {
    single<ConviWizardDataStore> { ConviWizardDataStore(get()) }
}