# flutter_mi_push

Android/iOS平台上集成小米push

## Android

* AndroidManifest.xml中声明以下权限：
```xml
<permission
    android:name="com.mi.finance.insightbank.permission.MIPUSH_RECEIVE"
    android:protectionLevel="signature" />
<uses-permission
    android:name="com.mi.finance.insightbank.permission.MIPUSH_RECEIVE" />
```
## iOS

* 开启Target -> Capabilities -> Background Modes，勾选Remote notifications
* 开启Target -> Capabilities -> Push Notifications
* info.plist中添加：
```xml
<key>MiSDKAppID</key>
<string>your iOS app id</string>
<key>MiSDKAppKey</key>
<string>your iOS app key</string>
<key>MiSDKRun</key>
<string>Online</string>
```
## Flutter

```dart
class MiPushManager {
  static const String APP_ID = ''; // your Android app id
  static const String APP_KEY = ''; // your Android app key

  static void init() {
    try {
      FlutterMiPush.init(APP_ID, APP_KEY);
    } on Exception catch (e) {
      print(e);
    }
  }
}
```