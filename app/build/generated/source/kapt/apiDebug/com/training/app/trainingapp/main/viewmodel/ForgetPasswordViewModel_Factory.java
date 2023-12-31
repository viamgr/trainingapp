package com.training.app.trainingapp.main.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
  @Override
  public ForgetPasswordViewModel get() {
    return newInstance();
  }

  public static ForgetPasswordViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ForgetPasswordViewModel newInstance() {
    return new ForgetPasswordViewModel();
  }

  private static final class InstanceHolder {
    private static final ForgetPasswordViewModel_Factory INSTANCE = new ForgetPasswordViewModel_Factory();
  }
}
