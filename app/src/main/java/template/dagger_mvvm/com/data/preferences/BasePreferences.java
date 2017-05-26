package template.dagger_mvvm.com.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

abstract class BasePreferences {

  abstract String getPreferenceName();

  final Context context;

  BasePreferences(Context context) {
    this.context = context;
  }

  protected void saveStringPreference(String key, String value) {
    SharedPreferences preferences = getSharedPreferences();
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString(key, value);
    editor.apply();
  }

  protected String getStringPreference(String key) {
    SharedPreferences preferences = getSharedPreferences();
    return preferences.getString(key, null);
  }

  protected void saveBooleanPreference(String key, boolean value) {
    SharedPreferences preferences = getSharedPreferences();
    SharedPreferences.Editor editor = preferences.edit();
    editor.putBoolean(key, value);
    editor.apply();
  }

  protected boolean getBooleanPreference(String key, boolean defaultValue) {
    SharedPreferences preferences = getSharedPreferences();
    return preferences.getBoolean(key, defaultValue);
  }

  protected void saveIntPreference(String key, int value) {
    SharedPreferences.Editor editor = getEditor();
    editor.putInt(key, value);
    editor.apply();
  }

  protected int getIntPreference(String key, int defaultValue) {
    SharedPreferences preferences = getSharedPreferences();
    return preferences.getInt(key, defaultValue);
  }

  protected void deletePreference(String key) {
    SharedPreferences preferences = getSharedPreferences();
    SharedPreferences.Editor editor = preferences.edit();
    editor.remove(key);
    editor.apply();
  }

  private SharedPreferences.Editor getEditor() {
    SharedPreferences preferences = getSharedPreferences();
    return preferences.edit();
  }

  private SharedPreferences getSharedPreferences() {
    return context.getSharedPreferences(getPreferenceName(), Context.MODE_PRIVATE);
  }

  public void clear() {
    SharedPreferences.Editor editor = getSharedPreferences().edit();
    editor.clear();
    editor.apply();
  }
}
