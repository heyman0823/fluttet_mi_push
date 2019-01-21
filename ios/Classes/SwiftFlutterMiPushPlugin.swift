import Flutter
import UIKit

public class SwiftFlutterMiPushPlugin: NSObject, FlutterPlugin, MiPushSDKDelegate, UNUserNotificationCenterDelegate {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "flutter_mi_push", binaryMessenger: registrar.messenger())
    let instance = SwiftFlutterMiPushPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("iOS " + UIDevice.current.systemVersion)
    if (call.method == "init") {
      initPush(result: result)
    }
  }

  private func initPush(result: @escaping FlutterResult) {
    MiPushSDK.registerMiPush(self, type: UIRemoteNotificationType(rawValue: UInt(0)), connect: true)
    result("success")
  }
}
