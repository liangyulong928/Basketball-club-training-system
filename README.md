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
2021年全运会辽宁省男子篮球队U22联队夺得金牌，而U19联队并未在小组赛出线。球队除了要考虑CBA联赛队伍的重组外，青训也提上辽宁省体育局的日程。该项目包含领队、教练、球员三个层次下的多个角色[1]。领队需完成球员注册、转会、合同管理三项功能，教练具备技术统计查看与分析、球员训练数据查看与分析、比赛赛程上传与输入等功能，专能训练师具备体能数统、体能数据上传功能。
### 1.2项目概述
2021年全运会辽宁省男子篮球队U22联队夺得金牌，而U19联队并未在小组赛出线。球队除了要考虑CBA联赛队伍的重组外，青训也提上辽宁省体育局的日程。该项目包含领队、教练、球员三个层次下的多个角色。领队需完成球员注册、转会、合同管理三项功能，教练具备技术统计查看与分析、球员训练数据查看与分析、比赛赛程上传与输入等功能，专能训练师具备体能数统、体能数据上传功能。
篮球俱乐部球员训练系统以总经理、球队经理、教练、助理教练及训练师五种角色对个人中心查阅、用户管理、球员管理、训练规划、训练分析及球员分析六项功能完成系统全部工作。
<img width="224" alt="image" src="https://user-images.githubusercontent.com/107730421/174423503-60783162-9140-491a-ad17-0db7ab5291e1.png">
### 1.3 核心功能需求描述
#### 1.3.1 比赛分析及训练分析
需求编号：CTS-CEO-6\t
需求描述：查看已完成记录的历史比赛数据。
CTS-CEO-6-1	通过左侧导航栏进入界面。界面顶部显示日期区间选择框，可选择比赛数据的起始时间，点击按钮后对下方数据进行更改。
CTS-CEO-6-2	进入界面后默认数据为近三个月内的所有数据。
CTS-CEO-6-3	每个比赛数据以抽屉形式展示，各抽屉间不影响，收起时显示时间、类型（比赛/训练）和记录员。
CTS-CEO-6-3	每个比赛数据以抽屉形式展示，收起时显示时间、类型（比赛/训练）和记录员。
CTS-CEO-6-4	抽屉展开后显示该场次下所有球员信息，包含姓名、得分、篮板、助攻、出场时间、投篮命中率（由命中数和出手数计算，三分球和罚球命中率与该计算方式相同）、三分球命中率、罚球命中率，以及竞技状态。
CTS-CEO-6-5	竞技状态在数据填入时采用决策模型分析。分析结果四分化，并采用不同颜色标签标记为状态火热、状态良好、状态较差和状态低迷。
#### 1.3.2 球员分析
需求编号：CTS-CEO-7
需求描述：对球员比赛及训练数据可视化查看。
CTS-CEO-7-1	通过左侧导航栏进入球员分析界面。界面顶部可选择联赛球员和省体育局注册球员，右侧可通过球员姓名模糊查询。
CTS-CEO-7-2	球员数据卡每排显示两人，上方显示姓名可点击后进入球员详细信息蒙版，下方为该球员一年内所有比赛和训练数据均值设计的雷达图。雷达图显示场均得分、场均篮板、场均助攻、投篮命中率、三分球命中率和罚球命中率信息。
CTS-CEO-7-3	通过姓名点击进入蒙版，蒙版中显示该球员近十场比赛的数据和竞技状态。（同CTS-CEO-6-4，将球员姓名改为时间）
