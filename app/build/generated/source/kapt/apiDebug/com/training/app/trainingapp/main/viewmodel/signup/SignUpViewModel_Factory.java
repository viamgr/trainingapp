package com.training.app.trainingapp.main.viewmodel.signup;

import com.trainning.app.domain.usecase.SignUpViewUseCase;
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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<SignUpViewUseCase> registerViewUseCaseProvider;

  public SignUpViewModel_Factory(Provider<SignUpViewUseCase> registerViewUseCaseProvider) {
    this.registerViewUseCaseProvider = registerViewUseCaseProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(registerViewUseCaseProvider.get());
  }

  public static SignUpViewModel_Factory create(
      Provider<SignUpViewUseCase> registerViewUseCaseProvider) {
    return new SignUpViewModel_Factory(registerViewUseCaseProvider);
  }

  public static SignUpViewModel newInstance(SignUpViewUseCase registerViewUseCase) {
    return new SignUpViewModel(registerViewUseCase);
  }
}
