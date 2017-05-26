package template.dagger_mvvm.com.data.networking;

import template.dagger_mvvm.com.BuildConfig;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pedrogloria on 24/01/17 .
 */
@Module public class NetworkModule {

    public NetworkModule() {
    }

    @Provides @Singleton @Named("baseUrl") String providesBaseUrl() {
        // This should come from a configuration file.
        return "http://baseUrl.example.com";
    }

    @Provides @Singleton HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
              : HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }

    @Provides @Singleton OkHttpClient provideHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    @Provides @Singleton Retrofit provideRestAdapter(OkHttpClient client,
          @Named("baseUrl") String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl)
              .client(client)
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build();
    }
}