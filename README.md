# LSPatch Framework

![Build](https://shields.io/github/workflow/status/LSPosed/LSPatch/Android%20CI?event=push&logo=github&label=Build) [![Crowdin](https://img.shields.io/badge/Localization-Crowdin-blueviolet?logo=Crowdin)](https://lsposed.crowdin.com/lspatch) [![Download](https://img.shields.io/github/v/release/LSPosed/LSPatch?color=orange&logoColor=orange&label=Download&logo=DocuSign)](https://github.com/LSPosed/LSPatch/releases/latest) [![Total](https://shields.io/github/downloads/LSPosed/LSPatch/total?logo=Bookmeter&label=Counts&logoColor=yellow&color=yellow)](https://github.com/LSPosed/LSPatch/releases)

## Introduction 

Rootless implementation of LSPosed framework, integrating Xposed API by inserting dex and so into the target APK.

## Supported Versions

- Min: Android 9
- Max: In theory, same with [LSPosed](https://github.com/LSPosed/LSPosed#supported-versions)

## 修改版声明

这是一个测试版本，不具备稳定性和规范性，用于免root环境下单独激活jshook，将在jshook未来版本中移除。

## Download

For stable releases, please go to [Github Releases page](https://github.com/LSPosed/LSPatch/releases)  
For canary build, please check [Github Actions](https://github.com/LSPosed/LSPatch/actions)  
Note: debug builds are only available in Github Actions  

## Usage

+ Through jar
1. Download `lspatch.jar`
1. Run `java -jar lspatch.jar`

+ Through manager
1. Download and install `manager.apk` on an Android device
1. Follow the instructions of the manager app

## Translation Contributing

You can contribute translation [here](https://lsposed.crowdin.com/lspatch).

## Credits

- [LSPosed](https://github.com/LSPosed/LSPosed): Core framework
- [Xpatch](https://github.com/WindySha/Xpatch): Fork source
- [Apkzlib](https://android.googlesource.com/platform/tools/apkzlib): Repacking tool

## License

LSPatch is licensed under the **GNU General Public License v3 (GPL-3)** (http://www.gnu.org/copyleft/gpl.html).
