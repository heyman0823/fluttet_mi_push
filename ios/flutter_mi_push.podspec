#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html
#
Pod::Spec.new do |s|
  s.name             = 'flutter_mi_push'
  s.version          = '0.0.1'
  s.summary          = 'Flutter mi push plugin.'
  s.description      = <<-DESC
Flutter mi push plugin.
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.author           = { 'Your Company' => 'email@example.com' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.dependency 'Flutter'
  s.frameworks = 'MobileCoreServices', 'SystemConfiguration', 'UserNotifications', 'CFNetwork', 'CoreTelephony'
  s.libraries = 'xml2', 'z', 'resolv'
  s.vendored_libraries = 'Classes/libMiPushSDK.a'
  s.static_framework = true
  s.ios.deployment_target = '8.0'
end

