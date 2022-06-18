# Graduation-Project_Yulong_DPU_CS
The basketball club player training system was designed for my undergraduate graduation and completed the writing of graduation thesis. The project completed the distributed development with Vue and spring cloud framework.
## 摘要
本设计针对辽宁省男子篮球俱乐部在全运会中展现出青训队员能力不足的问题，通过开发集成球队管理，训练规划和球员分析的多角色一体化平台，帮助球队挖掘潜力球员。本项目采用Vue + Spring Cloud框架实现前后端分离的微服务架构设计，使用服务注册中心和负载均衡的架构特点，完成系统的并发与弹性扩容。此外，使用随机森林算法完成训练数据的分析和预测，并使用可视化组件直观显示球员的竞技状态和技术特点。
### 关键词
篮球；训练；微服务；服务注册
## Abstract
This design aims at the problem that the Liaoning Men's Basketball Club shows the insufficient capacity of the youth training team in the National Games. Through the development of an integrated team management, training planning and player analysis multi-role integrated platform, it helps the team to tap potential players. This project uses Vue + Spring Cloud framework to achieve front-end and back-end separation of micro-service architecture design, and uses the architecture features of service registry and load balancing to complete the concurrency and flexibility expansion of the system. In addition, the random forest algorithm is used to analyze and predict the training data, and the visual components are used to visualize the players' competitive status and technical characteristics.
### Key words
Basketball; Training; Microservices; Service Registration
## 1、项目需求分析
### 1.1 项目简介
2021年全运会辽宁省男子篮球队U22联队夺得金牌，而U19联队并未在小组赛出线。球队除了要考虑CBA联赛队伍的重组外，青训也提上辽宁省体育局的日程。该项目包含领队、教练、球员三个层次下的多个角色。领队需完成球员注册、转会、合同管理三项功能，教练具备技术统计查看与分析、球员训练数据查看与分析、比赛赛程上传与输入等功能，专能训练师具备体能数统、体能数据上传功能。

### 1.2项目概述
2021年全运会辽宁省男子篮球队U22联队夺得金牌，而U19联队并未在小组赛出线。球队除了要考虑CBA联赛队伍的重组外，青训也提上辽宁省体育局的日程。该项目包含领队、教练、球员三个层次下的多个角色。领队需完成球员注册、转会、合同管理三项功能，教练具备技术统计查看与分析、球员训练数据查看与分析、比赛赛程上传与输入等功能，专能训练师具备体能数统、体能数据上传功能。
篮球俱乐部球员训练系统以总经理、球队经理、教练、助理教练及训练师五种角色对个人中心查阅、用户管理、球员管理、训练规划、训练分析及球员分析六项功能完成系统全部工作。
<img width="224" alt="image" src="https://user-images.githubusercontent.com/107730421/174424002-61657d01-b091-47ed-a86f-09d7de645496.png">
### 1.3 核心功能需求描述
#### 1.3.1 比赛分析及训练分析
需求编号：CTS-CEO-6

需求描述：查看已完成记录的历史比赛数据。

CTS-CEO-6-1 通过左侧导航栏进入界面。界面顶部显示日期区间选择框，可选择比赛数据的起始时间，点击按钮后对下方数据进行更改。

CTS-CEO-6-2 进入界面后默认数据为近三个月内的所有数据。

CTS-CEO-6-3 每个比赛数据以抽屉形式展示，各抽屉间不影响，收起时显示时间、类型（比赛/训练）和记录员。

CTS-CEO-6-3 每个比赛数据以抽屉形式展示，收起时显示时间、类型（比赛/训练）和记录员。

CTS-CEO-6-4 抽屉展开后显示该场次下所有球员信息，包含姓名、得分、篮板、助攻、出场时间、投篮命中率（由命中数和出手数计算，三分球和罚球命中率与该计算方式相同）、三分球命中率、罚球命中率，以及竞技状态。

CTS-CEO-6-5 竞技状态在数据填入时采用决策模型分析。分析结果四分化，并采用不同颜色标签标记为状态火热、状态良好、状态较差和状态低迷。

#### 1.3.2 球员分析
需求编号：CTS-CEO-7

需求描述：对球员比赛及训练数据可视化查看。

CTS-CEO-7-1 通过左侧导航栏进入球员分析界面。界面顶部可选择联赛球员和省体育局注册球员，右侧可通过球员姓名模糊查询。

CTS-CEO-7-2 球员数据卡每排显示两人，上方显示姓名可点击后进入球员详细信息蒙版，下方为该球员一年内所有比赛和训练数据均值设计的雷达图。雷达图显示场均得分、场均篮板、场均助攻、投篮命中率、三分球命中率和罚球命中率信息。

CTS-CEO-7-3 通过姓名点击进入蒙版，蒙版中显示该球员近十场比赛的数据和竞技状态。（同CTS-CEO-6-4，将球员姓名改为时间）

## 2.项目概要设计

### 2.1 功能结构

本系统在功能上划分为六项，分别是以登录、注册、权限鉴别和修改密码组成的通用功能；以用户角色授权、职位调动、解约组成的用户管理功能模块；对训练规划的新增、修改和查阅组成训练规划功能模块；以数据统计的查看、数据录入和比赛搜索组成训练和比赛分析功能模块；由联赛签约、球员注册和球员调动组成的球员管理模块以及由雷达图和竞技走势组成的球员分析模块。

<img width="403" alt="image" src="https://user-images.githubusercontent.com/107730421/174424006-2aa105f7-a702-4a8a-8d2f-0082a0a6cdc7.png">


### 2.2 架构设计

本项目基于Vue和Spring Cloud框架搭建的前后端分离式微服务项目[2]。通过Vue-cli脚手架工具创建前端工程化项目完成界面路由跳转、与服务订阅者间的异步通讯和基于组件形式的界面渲染，并通过MVVM模型完成组件数据和变量间的绑定[3]。当工程化项目向服务订阅者发送请求时，首先经过由Spring Cloud Gateway搭建的网关内嵌的过滤器[4]完成身份鉴别和权限鉴定，并根据请求的服务类型向不同的服务订阅者进行路由重定向。

请求在服务订阅者中通过Feign客户端对HTTP API进行包装，并通过服务名向服务注册中心拉取服务，服务注册中心返回相应接口获取操作后，服务订阅者将服务响应给前端进行渲染，完成服务调用。

服务提供者根据处理内容不同使用两个不同的平台进行开发，而后根据微服务特性在服务注册中心实现跨平台交互。将基于随机森林算法对球员训练数据分析的模型使用Python平台实现，并使用Flask框架进行封装并接入Eureka服务注册中心；将对数据库进行增删改操作的服务模块使用Mybatis封装通用映射并使用Spring Boot组成多端口的微服务模组。

<img width="386" alt="image" src="https://user-images.githubusercontent.com/107730421/174424013-39901014-66e6-4ec2-a89e-224c0ea86bf3.png">


## 3.项目详细设计

### 3.1 数据库设计

针对平台使用者（即用户），针对其所在单位和职位进行拓展，针对用户的职位对应平台内使用的功能，通过所在单位相应相应级别权限。用户可以管理球员合同标签，监测球员合同意向，球员合同标签对应相应球员。球员通过分属单位可以参加对应级别比赛，在比赛中的数据统计信息存入数据库。

<img width="386" alt="image" src="https://user-images.githubusercontent.com/107730421/174424016-6c128730-916b-43ac-b9fb-09baeea3627f.png">


### 3.2 服务注册中心机制设计

#### 3.2.1 服务注册中心机制说明

当服务提供者启动项目后，通过项目内配置好的服务注册中心地址将服务注册信息主动到注册中心，服务订阅者可以通过服务提供者项目名称访问服务注册中心并获取服务提供者的注册信息。

#### 3.2.2 服务注册中心搭建与参数配置

通过Maven工程下引入spring-cloud-starter-netflix-eureka-server（Greenwich.SR1）依赖，并配置10000端口号，参数配置如表3.1所示[5]。

| 配置参数（eureka.server.*） | 取值   | 说明                                                         |
| --------------------------- | ------ | ------------------------------------------------------------ |
| enableSelfPreservation      | true   | 标记启动注册中心自我保护机制，若统计到15分钟内损失超过15%的心跳会触发自我保护[6]，不再剔除服务提供者。 |
| waitTimeInMsWhenSyncEmpty   | 300000 | 标记服务器获取不到集群中其他服务器的等待时间为1000*60*5毫秒，即5分钟。 |
| register-with-eureka        | false  | 标记不将本服务注册到服务注册中心，即服务订阅者不可拉取该服务[7]。 |
| fetch-registry              | false  | 标记不获取Eureka Server注册表，即本服务中无需获取连接Eureka的服务。 |

### 3.3 模块设计

#### 3.3.1 比赛分析模块设计

通过日期区间选择器选择要查询比赛和训练的起止时间，搜索在时间范围内的比赛。对查询的比赛通过抽屉栏的展开可以查询在该场比赛中所有球员的数据统计以及系统分析的球员状态。

#### 3.3.2 训练规划模块设计

从查询时间之后的所有训练规划会通过日历组件中嵌入的标签显示，此外，通过页面头部按钮也可以查询列表形式的训练规划。通过按钮点击进入新增训练规划，选择训练时间、训练形式和记录员并选择参训队员，而后会创建一个新的训练计划在日历组件中显示。通过按钮点击进入新增训练规划，选择训练时间、训练形式和记录员并选择参训队员，而后会创建一个新的训练计划在日历组件中显示。

#### 3.3.3 比赛分析模块设计

通过日期区间选择器选择要查询比赛和训练的起止时间，搜索在时间范围内的比赛。对查询的比赛通过抽屉栏的展开可以查询在该场比赛中所有球员的数据统计以及系统分析的球员状态。

<img width="167" alt="image" src="https://user-images.githubusercontent.com/107730421/174424019-657caf9c-a211-472d-8a31-5db272c3d7ec.png">

#### 3.3.4 用户查询与筛选

总经理在进行角色管理时，可对本部门所有职工以及下属部门所有职工进行管理。如果管理人较多的情况下，会存在查找时间较长等情况出现。在本模块设计中，通过使用姓名/手机号搜索栏可以进行模糊查询；同时，在表格中，也通过表头的筛选机制选择指定单位或指定职位的所有员工。

<img width="151" alt="image" src="https://user-images.githubusercontent.com/107730421/174424024-cbe1c4de-0545-478e-90d5-a6d5377d0a30.png">


## 4.数据模型与预测

### 4.1 数据源获取与数据清洗

在本项目数据库中从官方数据中心贝泰科技获取了CBA联赛近两个赛季辽宁队球员所有比赛数据，通过比赛结果将赢球场次且比赛分差超过20分的比赛标记为训练，其余标记为正式比赛。将球员数据统计中如得分、篮板等个人比赛数据作为数据源，球员比赛正负值作为数据结果。根据正负值分布规律，对其进行均值和标准差计算。计算得出，正负值平均值为6，标准差为13，根据此结果对正负值进行4部分划分，分别代表球员在本场比赛竞技状态等级。

### 4.2 训练流程

使用CART决策数[8]中引入基尼指数的概念，将连续型数据离散化进行决策。将清洗好的数据存入数据库并利用接口获取数据[9]。通过对特征值的有放回抽取，通过限制最大叶子结点数和最大深度约束[10]，并生成众多决策树构成随机森林[11]。

### 4.3 训练结果分析

以43号决策树的部分决策过程为例，当得分大于等于8.5分时，会考察比赛是否为训练赛，确认为训练赛后考察犯规数是否小于等于5.5，以此规则直到获得基尼指数为最高纯净值时该决策结果即为本决策树决策结果。通过所有决策树构成的随机森林的结果统计，获取最终结果。

<img width="284" alt="image" src="https://user-images.githubusercontent.com/107730421/174424030-95cbb3fc-f9a1-4431-bf12-2013d94644ce.png">

## 5.项目实现

### 5.1 分角色导航栏

在多角色一体化平台设计中，通过一个登录接口实现个人主页中的定制化导航栏是本小节设计关键。在对个人中心界面进行初始化时，通过获取用户对应角色所拥有的权限列表将其映射为导航栏信息，完成该设计。

<img width="128" alt="image" src="https://user-images.githubusercontent.com/107730421/174424033-8ad2b570-4bbd-4680-be8e-4e714b384986.png">
<img width="124" alt="image" src="https://user-images.githubusercontent.com/107730421/174424034-185970a7-68fc-434c-8ec0-b674afd08813.png">


### 5.2 指定单位/职位筛选栏

在<th>标签中装入<el-dropdown>标签并绑定事件，参数在<el-dropdown-menu>中使用v-model绑定，参数值使用command绑定。在model中设置空数组，当数据满足参数要求时，向空数组中加入该对象与标签绑定。设置一个布尔类型初始值，当筛选结束为空时，布尔值设置为True，显示未搜索到结果的提示信息。

<img width="183" alt="image" src="https://user-images.githubusercontent.com/107730421/174424039-95ac3f75-3ddf-47d8-89e2-f5813c6437d9.png">

### 5.3 姓名/手机号模糊搜索

在<input>标签中加入@input属性绑定事件，对目标列表进行排查，对姓名属性或者手机号属性中包含参数（即item.name.indexOf(key_word)>-1）的对象加入到预先设置好的空数组中，在事件触发时对数组和布尔值初始化。

<img width="278" alt="image" src="https://user-images.githubusercontent.com/107730421/174424044-e9b2edd1-8e1d-4fb1-8dde-e0b1e2b240fa.png">

### 5.4 球员分析模块雷达图设计与实现

通过echarts.init(document.getElementById(this.player.id))初始化echarts组件，并将数据渲染到option.series.data.value中，可实现雷达图的展示效果。如图5.14所示。在数据获取中，雷达图需要展示平均数据，为六个浮点数组成的数组；在球员姓名的超链接处还要显示球员近十场比赛的数据，因此使用JSON在后端对数据进行封装。

<img width="224" alt="image" src="https://user-images.githubusercontent.com/107730421/174424048-af16b6d9-a2ee-4d9c-ae63-5f2459b2958b.png">

### 5.5 训练规划模块代办事件设计与实现

使用<el-calendar>标签初始化日历组件，设置内容自定义。通过调用接口getAllPlan获取训练计划。使用组件中data.day.split('-').slice(1)[0]获取月份，data.day.split('-').slice(2).join('-')获取日期，训练日期与数值匹配时，会添加训练标签至日历中。

<img width="294" alt="image" src="https://user-images.githubusercontent.com/107730421/174424050-65ff91d6-6dac-44eb-8aa2-c4584f7b96ca.png">
