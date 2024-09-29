# WH40K-DOW2-chn-translation

_项目开发正在进行中 (This project is working in progress)_

《战锤40K：战争黎明2 周年纪念版》简体中文翻译

### 简介

《战锤40K：战争黎明2 周年纪念版》发布于 2024 年 9 月 20 日，在 Steam 平台上的公告页面地址：
https://store.steampowered.com/news/app/15620/view/4674262774470822179

该版本包含了下面三个游戏内容以及若干 DLC：
- 战锤 40K：战争黎明 2 （Warhammer 40,000: Dawn of War II）
- 战锤 40K：战争黎明 2 报应 （Warhammer 40,000: Dawn of War II - Retribution）
- 战锤 40K：战争黎明 2 混沌崛起 （Warhammer 40,000: Dawn of War II - Chaos Rising）

因为包含三个游戏的内容，因此以前的汉化补丁都会存在内容不全的问题，需要重新整理。

### 游戏文本资源

游戏中的文本内容包含在下面的资源文件中：<br>
`Dawn of War 2\GameAssets\Locale\English\DOW2.ucs`

该文件为文本文件，编码如下：
- 编码格式为 UTF-16+（有的编辑器也会显示为 "UTF-16LE" ），BOM 标识为 `\uFEFF`
- 文本内容使用 CRLF 换行符
- 每行文本是一个 key-value 对，用 `\t` 分隔

### 项目内容

我已经收集到三个版本各自的汉化补丁，并放在 `chinese` 目录:
- `chinese/down2`: 战锤 40K：战争黎明 2
- `chinese/down2_c`: 战锤 40K：战争黎明 2 混沌崛起
- `chinese/down2_r`: 战锤 40K：战争黎明 2 报应

接下来要做的就是将这三个汉化补丁内容合到一起。好在三个游戏中，每条文本都有唯一的
ID，也就是每个 ID 在三个游戏中的含义是相同的。因此，可以将三个游戏的汉化补丁合并为一个文件。

### 汉化补丁使用方法：

将 `chinese` 目录下的文件复制到 `Dawn of War 2\GameAssets\Locale\English\` 目录下，覆盖原有文件即可。

覆盖前请备份原有文件，以防止出现意外。

### 其他相关：

- [运行游戏可能出现的技术问题贴](https://steamcommunity.com/sharedfiles/filedetails/?id=2964024221)
- [修复游戏在多核下可能崩溃问题的补丁](https://github.com/maximumgame/DOW2CoreFix/releases/tag/v1.0)
