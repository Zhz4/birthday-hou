# 微微生日网站后台
<p align="center">
<a href="https://github.com/Zhz4"><img src="https://img.shields.io/badge/author-zhz4-blue"></a>
<a href="https://cn.vuejs.org/"><img src="https://img.shields.io/badge/language-vue3-yellowgreen"></a>
<a href="https://nodejs.org/download/"><img src="https://img.shields.io/badge/node-16.13.2-brightgreen"></a>
</p>

## 项目介绍
本项目是自己突发奇想，在npy生日之际写一个网站也算是对vue3+springboot的一次尝试
前端项目用了一些网上的开源库有优化页面布局，例如：动态背景，流式瀑布，网页弹幕，虚拟列表加载过渡动画等等。
后端使用的springboot2 版本，图片和视频存储使用的是七牛云的对象存储（原本是想用阿里云的oss对象储存的，但是我的域名没有备案，就放弃了这个方案）
## 项目功能
- 生日祝福（弹幕形式展示）、
- 网站音乐
- 图片库（流式瀑布展示）
- 视频播放
## 技术栈
前端： vue3 + ts + scss + Element-Plus  
后端： springboot2  
服务的：阿里云centos服务器+七牛云对象存储
## 项目使用
安装依赖包
```xshell
npm install
```
进入到 `util/request.ts` 中修改后端接口地址
```ts
baseURL: "xxxx", // 地址
```
运行项目
```xShell
npm run dev
```
## 项目截图
### PC 端截图
<div align="center">
   <img src="https://cdn.nlark.com/yuque/0/2023/jpeg/26376404/1692088086267-615bc8fc-e848-4eb0-b3c8-6de0d64841d4.jpeg"  height=160>
   <img src="https://cdn.nlark.com/yuque/0/2023/png/26376404/1692088091462-9fea6520-e9d4-484f-9a7a-52d2de0684e0.png?x-oss-process=image%2Fresize%2Cw_825%2Climit_0" height=160>
   <img src="https://cdn.nlark.com/yuque/0/2023/png/26376404/1692088097138-20421b7a-6edc-4149-817b-97e4cfb46c22.png?x-oss-process=image%2Fresize%2Cw_825%2Climit_0" height=160>
   <img src="https://cdn.nlark.com/yuque/0/2023/jpeg/26376404/1692088102628-e657bb34-ffae-48df-9d16-4c9a15f3b069.jpeg" height=160>
</div>

### 移动端截图
<div align="center">
   <img src="https://cdn.nlark.com/yuque/0/2023/jpeg/26376404/1692088027044-fb9a283f-24d5-4e45-8b6a-9ec5f81b6f3e.jpeg?x-oss-process=image%2Fresize%2Cw_825%2Climit_0%2Finterlace%2C1"  height=400>
   <img src="https://cdn.nlark.com/yuque/0/2023/jpeg/26376404/1692088036871-9cfc3fcb-958e-4e69-9ea3-26c7c9674aa7.jpeg"  height=400>
   <img src="https://cdn.nlark.com/yuque/0/2023/jpeg/26376404/1692088044002-e29e3203-7eae-4335-9343-67f59771c5f3.jpeg"  height=400>
   <img src="https://cdn.nlark.com/yuque/0/2023/jpeg/26376404/1692088051510-46fa838c-e2ae-4887-a91c-2c6a204e7ee6.jpeg"  height=400>
</div>

### 后端项目地址
待开源中..


## 使用前端开源库
- [视频播放器](https://codelife.cc/vue3-video-play/guide/install.html#props)
- [弹幕](https://github.com/hellodigua/vue-danmaku)
- [流式瀑布](https://github.com/shershen08/vue-masonry)
- [滚动展示动画](https://scrollrevealjs.org/)