import 'dart:async';

import 'package:flutter/services.dart';

class FlutterMiPush {
  static const MethodChannel _channel = const MethodChannel('flutter_mi_push');

  static void init(String appId, String appKey) async {
    final Map<String, dynamic> params = <String, dynamic>{
      'appId': appId,
      'appKey': appKey,
    };
    await _channel.invokeMethod('init', params);
  }
}
