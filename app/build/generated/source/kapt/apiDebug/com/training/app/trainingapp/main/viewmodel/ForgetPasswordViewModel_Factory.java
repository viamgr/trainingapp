package com.training.app.trainingapp.main.viewmodel;

import com.training.app.trainingapp.main.viewmodel.forgetpassword.ForgetPasswordViewModel;
import com.trainning.app.domain.usecase.ForgetPasswordUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ForgetPasswordViewModel_Factory implements Factory<ForgetPasswordViewModel> {
  private final Provider<ForgetPasswordUseCase> forgetPasswordUseCaseProvider;

  public ForgetPasswordViewModel_Factory(
      Provider<ForgetPasswordUseCase> forgetPasswordUseCaseProvider) {
    this.forgetPasswordUseCaseProvider = forgetPasswordUseCaseProvider;
  }

  @Override
  public ForgetPasswordViewModel get() {
    return newInstance(forgetPasswordUseCaseProvider.get());
  }

  public static ForgetPasswordViewModel_Factory create(
      Provider<ForgetPasswordUseCase> forgetPasswordUseCaseProvider) {
    return new ForgetPasswordViewModel_Factory(forgetPasswordUseCaseProvider);
  }

  public static ForgetPasswordViewModel newInstance(ForgetPasswordUseCase forgetPasswordUseCase) {
    return new ForgetPasswordViewModel(forgetPasswordUseCase);
  }
}
