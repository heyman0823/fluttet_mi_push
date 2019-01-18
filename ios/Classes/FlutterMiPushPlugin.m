#import "FlutterMiPushPlugin.h"
#import <flutter_mi_push/flutter_mi_push-Swift.h>

@implementation FlutterMiPushPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterMiPushPlugin registerWithRegistrar:registrar];
}
@end
