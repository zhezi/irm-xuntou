# API
> 地址
https://ssl-fof.xingyoucai.com

> 创建产品

| 接口     | 说明     |
| :------------- | :------------- |
| /api/v1.2/save/fundInfo            | 保存基金信息         |
| /api/v1.2/save/fundNvList          | 保存净值(多个)       |
| /api/v1.2/save/fundPostitionList   | 保存基金持仓(多个)   |
| /api/v1.2/save/futuresHoldData     | 保存期货持仓(单个)   |
| /api/v1.2/save/futuresHoldDataList | 保存期货持仓(多个)   |
| /api/v1.2/save/futuresTradeData    | 保存结算单(单个)     |
| /api/v1.2/save/futuresTradeDataList| 保存结算单(多个)     |
---
> 生成数据

| 接口 | 说明     |
| :------------- | :------------- |
| /api/v1.2/generator/{innerCode}  | 生成数据       |
---
> 取数据

| 接口 | 说明     |
| :------------- | :------------- |
| /api/v1.2/chart/{innerCode}/{types}  | 计算数据       |
---


# 基金信息
> 接口
* /api/v1.2/save/fundInfo

> 方法
* POST

> 输入参数

| 参数 | 是否必填  | 说明    |
| :------------- | :------------- | :------------- |
| innerCode   |是    | 基金编号       |
| fundFullName  |是     | 基金名称       |
| strategyId1  |是| 投资策略1级分类:<br/>1.	中性策略<br/>2.	股票多头<br/>3.	期货策略<br/>4.	债券策略<br/>5.	混合策略<br/>6.	FOF<br/>7.	其他|
| strategyId2  |否   | 投资策略2级分类:<br/>1-EL 股票多头;<br/>2-MU 股票量化对冲策略;<br/>3-MT 择时对冲;<br/>4-AR 套利;<br/>5-AF 主观期货;<br/>6-QF 量化期货;<br/>7-BO 债券策略;<br/>8-MUL 混合多策略;<br/>9-FOF;<br/>10-OTH 其他|
| monitorLevel |否      | 账户监控等级：<br/>AA 自主发行产品<br/>周报，监控大类配置，风险指标<br/>A  对AA业绩风险有重要影响的产品<br/>每日更新净值，监控仓位，月度团队沟通<br/>B 对AA业绩风险影响较小的产品<br/>两个月团队沟通，不用监控仓位，定期监控净值<br/>C 通道产品<br/>监控预警清盘线<br/>O 分析产品数据       |
| establishDate |是   | 开始时间       |
| stopLossLine  |否  | 平仓线       |
| warningLine   |否| 警戒线       |
| workingState  |是| 基金状态: 1-正在进行;2-已经停止       |

# 净值
> 接口
* /api/v1.2/save/fundNvList

> 方法
* POST

> 输入参数

| 参数 |是否必填| 说明     |
| :-------------| :------------- | :------------- |
|  innerCode    |是  | 基金编号       |
|  nvAccum      |是  |   净值       |
|  tradeDate    |是  | 交易日       |
|  longValue    |否  | 多头市值<br/>FundPosition中security_type=1,5,6,7,9,13的资产市值为正数的累和       |
|  shortValue   |否  | 空头市值<br/>FundPosition中security_type=1,5,6,7,9,13的资产市值为负数的累和       |
|  margin       |否  | 保证金       |
|  totalCostValue  |否   | 实收资本       |
|  totalMarketValue |否   | 总市值       |


# 基金持仓
> 接口
*  /api/v1.2/save/fundPositionList

> 方法
* POST

> 输入参数

| 参数 |是否必填| 说明     |
| :-------------| :------------- | :------------- |
| innerCode     |是  | 基金编号      |
| tradeDate     |是 | 持仓日期      |
| securityCode  |是    | 证券ID      |
| securityName  |否     | 证券名称      |
| securityType  |是     | 证券类型1-	股票（1102股票投资，1102.65/81/82/83港股通，<br/>2-	投资基金（ETF）<br/>3-	保证金（1031存出保证金，<br/>4-	其他(1021备付金，<br/>（证券清算款，备付金，卖出回购，买入返售,短期借款）<br/>其中卖出回购和短期借款是负债类得减掉改数目。<br/>5-	股指期货<br/>6-	商品期货<br/>7-	债券期货<br/>8-	股指期权 （成本为负，则是卖出期权，成本为正，则是买入期权）<br/>9-	债券<br/>10-	应收利息<br/>11- 现金(1002存款,<br/>12- 私募产品 （其他私募产品，例如新晖1号，购买了中子星-星光E）<br/>13- 商品期权<br/>14- 负债|
| cost       | 是| 成本      |
| costPrice   |否    | 成本价格      |
| volume      |否 | 持仓量      |
| close      |否 | 市价      |
| marketCap    |否   | 持仓市值      |
| updateTime   |否    | 更新时间(yyyy-MM-dd HH:mm:ss)     |

# 期货持仓
> 接口
* /api/v1.2/save/futuresHoldData(单个)
* /api/v1.2/save/futuresHoldDataList(全部)

> 方法
* POST

> 输入参数

| 参数 | 说明     |
| :------------- | :------------- |
| accountId       | 期货账户号       |
| tradingDate       | 交易日期       |
| accountNo       | 基金账户名       |
| contractCode       | 合约代码       |
| sessionId       | 交易回合号       |
| transactionFlag       | 买卖<br/>1.	买<br/>-1.	卖      |
| speculationHedging       | 投保<br/>1.投机<br/>2.套利<br/>3.套保<br/>       |
| holdingQuantity       | 持仓数量       |
| tradingMargin       | 保证金       |
| holdPl       | 逐日盯市盈亏      |
| cumPl       | 逐笔盯市盈亏      |
| averagePrice       | 持仓均价       |
| preSettlePrice       | 前结算价       |
| securityType       | 合约类型<br/>1．	商品期货<br/>2．	股指期货<br/>3．	国债期货<br/>       |
| settlePrice       | 结算价       |
| updateTime       | 更新日期       |

# 结算单
> 接口
* /api/v1.2/save/futuresTradeData(单个)
* /api/v1.2/save/futuresTradeDataList(全部)

> 方法
* POST

>输入参数

| 参数 | 说明     |
| :------------- | :------------- |
| tradingDate       | 交易日期       |
| accountId       | 基金账户号       |
| accountNo       | 期货账户名       |
| tradingTime       | 交易时间       |
| contractCode       | 合约代码       |
| sessionId       | 交易流水号       |
| securityType       | 合约类型 <br/>1．	商品期货<br/>2．	股指期货<br/>3．	国债期货<br/>|
| transactionFlag       | 买卖<br/>1.	买<br/>-1.	卖      |
| openClose       | 开平<br/>1.	开仓<br/>2.	平仓<br/>3.	平昨<br/>4.	平今<br/> |
| tradingPrice | 成交价格|
| tradingQuantity|成交手数|
| tradingValue|成交金额|
| tradingCategory| 成交类型<br/>1.	普通成交<br/>2.	组合衍生成交<br/>|
| speculationHedging       | 投保<br/>1.投机<br/>2.套利<br/>3.套保<br/>       |
| liquidPl       | 逐日盯市盈亏       |
| cumPl       | 逐笔盯市盈亏      |
| commissionFee| 手续费|
| dealDate | 实际成交日期|
| updateTime       | 更新日期       |

# API(生成数据)
> 接口

**/api/v1.2/generator/{innerCode}**

> 方法
* GET

> 输入参数

| 字段     | 类型     | 说明     |
| :------- | :-------| :------------- |
| innerCode     | string  | 基金编码     |

> 输出参数

| 字段     | 类型     | 说明     |
| :------- | :-------| :------------- |
| status   | int  | 0正常-1异常|
| message  | string  | 异常信息|


# API(取数据)
> 返回日期格式为时间戳
例:1501689600000
## 债券策略
> 接口

**/api/v1.2/chart/{innerCode}/{types}**

> 方法
* GET

> 输入参数

| 字段     | 类型     | 说明     |
| :------- | :-------| :------------- |
| innerCode     | string  | 基金编码|
> 输出参数

| 编号     | 说明     |
| :------------- | :------------- |
| chart101      | <a href="https://code.hcharts.cn/chartData_json/edHLnq">地域分布</a>    |
| chart102      | <a href="https://code.hcharts.cn/chartData_json/CMULn7">债券分类</a>       |
| chart103      | <a href="https://code.hcharts.cn/chartData_json/KH9Lno">利率债-二级分类 </a>      |
| chart104      | <a href="https://code.hcharts.cn/chartData_json/OEZLnb">信用债-是否为城投债 </a>      |
| chart105      | <a href="https://code.hcharts.cn/chartData_json/pCrL3r">交易市场 </a>      |
| chart106      | <a href="https://code.hcharts.cn/chartData_json/R55L3G">信用债-评级</a>       |
| chart107      | <a href="https://code.hcharts.cn/chartData_json/BMHL3T">用债-所属行业</a>       |
| chart108      | <a href="https://code.hcharts.cn/chartData_json/5PBL3y">到期期限</a>       |
| chart109      | <a href="https://code.hcharts.cn/chartData_json/ORFL3m">久期策略</a>       |
| chart110     | <a href="https://code.hcharts.cn/chartData_json/ZYJL3z">组合加权久期</a>       |
| chart111     | <a href="https://code.hcharts.cn/chartData_json/9YrL3n">账户杠杆率</a>|
| chart112     | <a href="https://code.hcharts.cn/chartData_json/VhpL33">估算净值</a>      |
| chart113     | <a href="https://code.hcharts.cn/chartData_json/VOPL3l">信用利差风险DTS</a>       |
| chart114     | <a href="https://code.hcharts.cn/chartData_json/eY9L3s">业绩归因</a>       |
| chart115     | <a href="https://code.hcharts.cn/chartData_json/4trL3j">非流动性个券占比</a>       |
---
## 股票策略
> 输出参数

| 编号     | 说明     |
| :------------- | :------------- |
| chart201       |<a href="https://code.hcharts.cn/chartData_json/RZHLs1"> 股票市值</a>      |
| chart202       |<a href="https://code.hcharts.cn/chartData_json/JpILsw"> 流动性冲击</a>      |
| chart203       |<a href="https://code.hcharts.cn/chartData_json/K5ILsx"> 股票持仓行业分布</a>      |
| chart204       |<a href="https://code.hcharts.cn/chartData_json/5IZLsD"> 行业上中下游分布</a>      |
| chart205       |<a href="https://code.hcharts.cn/chartData_json/rVJLsi"> 收益归因 </a>     |
| chart206       |<a href="https://code.hcharts.cn/chartData_json/CEOLsv">收益归因-行业收益配置</a> |
| chart207       |<a href="https://code.hcharts.cn/chartData_json/FIYLsA"> 收益归因-个股选择收益</a>      |
| chart208       |<a href="https://code.hcharts.cn/chartData_json/R5hLsk"> 收益归因-基金经理择时收益</a>      |
| chart209       |<a href="https://code.hcharts.cn/chartData_json/r9ZLsW"> 市值分布</a>      |
| chart210       |<a href="https://code.hcharts.cn/chartData_json/UeYLsa"> 大中小盘收益归因</a>      |
| chart211       |<a href="https://code.hcharts.cn/chartData_json/rOhLsq"> 周度换手率</a>      |
| chart213       |<a href="https://code.hcharts.cn/chartData_json/CFCLso"> 舆情监控</a>      |
| chart214       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/1">风格暴露</a>     |
| chart217       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/2">情景分析</a>|
| chart218       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/3">股票持仓VaR</a>|
| chart219       |<a href="https://code.hcharts.cn/temp/rZd6LT/2">因子暴露&收益贡献</a>|
| chart220       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/7">风格趋势</a>|
| chart221       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/4">股票仓位历史走势</a> |
| chart222       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/5">净暴露历史走势</a> |
| chart223       |<a href="https://code.hcharts.cn/xingyoucai/5epXwl/6">年化滚动换手率(20交易日)</a>|

---
## 期权策略
> 输出参数

| 编号 | 说明     |
| :------------- | :------------- |
| chart301      | <a href="https://code.hcharts.cn/chartData_json/EeELsb">期权组合 </a>      |
| chart302      | <a href="https://code.hcharts.cn/chartData_json/PEOLjr">期权合约 </a>      |
| chart303      | <a href="https://code.hcharts.cn/chartData_json/U5OLjG">期权组合 </a>      |
| chart304      | <a href="https://code.hcharts.cn/chartData_json/KSSLjT">期权组合 </a>      |
| chart820      | <a href="https://code.hcharts.cn/chartData_json/ON4Ljf">投资解读 </a>      |

---
## FOF策略
> 输出参数

| 编号 | 说明     |
| :------------- | :------------- |
| chart601       | <a href="https://code.hcharts.cn/chartData_json/hCJLjm">大类配置收益  </a>     |
| chart602       | <a href="https://code.hcharts.cn/chartData_json/tHOLjz">大类配置收益  </a>     |
| chart603       | <a href="https://code.hcharts.cn/chartData_json/pYOLjn">大类配置收益 </a>      |
| chart604       | <a href="https://code.hcharts.cn/chartData_json/UtFLj3">大类配置收益  </a>     |
| chart605       | <a href="https://code.hcharts.cn/chartData_json/BdpLjl">收益归因-中性 </a>     |
| chart606       | <a href="https://code.hcharts.cn/chartData_json/Id5Ljs">收益归因-股票 </a>     |
| chart607       | <a href="https://code.hcharts.cn/chartData_json/5ZeLjj">收益归因-期货  </a>    |
| chart608       | <a href="https://code.hcharts.cn/chartData_json/NSPLjg">收益归因-债券 </a>     |
| chart609       | <a href="https://code.hcharts.cn/chartData_json/4EMLj6">子基金权重分析</a>      |
| chart612         | <a href="https://code.hcharts.cn/chartData_json/phSLj8">子基金波动率贡献分析</a>|
---
## 期货
> 输出参数

| 编号 | 说明     |
| :------------- | :------------- |
| chart801       | <a href="https://code.hcharts.cn/chartData_json/hJNLjX">多空合约逐笔盈利分析  </a>     |
| chart802       | <a href="https://code.hcharts.cn/chartData_json/EZFLjQ">各品种逐笔盈利分析 </a>      |
| chart803       | <a href="https://code.hcharts.cn/chartData_json/CpFLjL">期货账户逐日盈亏 </a>      |
| chart804       | <a href="https://code.hcharts.cn/chartData_json/P4JLjc">日交易效率    </a>   |
| chart805       | <a href="https://code.hcharts.cn/chartData_json/CJYLju"> 各品种交易效率 </a>      |
| chart816       | <a href="https://code.hcharts.cn/chartData_json/FeRLjw">投资解读</a> |
| chart817       | <a href="https://code.hcharts.cn/chartData_json/tVNLjx">各产品日盈亏</a>|
| chart818       | <a href="https://code.hcharts.cn/chartData_json/9tBLjD">大类品种累计盈亏</a>|
| chart819       | <a href="https://code.hcharts.cn/chartData_json/pdHLji">仓位分析</a> |

---
## 基础数据
> 输出参数

| 编号 | 说明     |
| :------------- | :------------- |
| chart806       | <a href="https://code.hcharts.cn/chartData_json/E9BLjv">持仓总览</a>|
| chart807       | <a href="https://code.hcharts.cn/chartData_json/K5FLj2">基础线</a>|
| chart809       |<a href="https://code.hcharts.cn/chartData_json/eVrLjW">月度收益</a>|
| chart810       |<a href="https://code.hcharts.cn/chartData_json/VNZLja">回撤对比</a>|
| chart811       |<a href="https://code.hcharts.cn/chartData_json/BStLjq">大类品种收益时序</a>|
| chart812       |<a href="https://code.hcharts.cn/chartData_json/KeZLj7">20期滚动表现</a>|
| chart813       |<a href="https://code.hcharts.cn/chartData_json/SENLg0">账户保证金比例及杠杆率</a>|
| chart814       |<a href="https://code.hcharts.cn/chartData_json/IOPLgf">期货持仓多空对比(multi),最新持仓合约分布(wgt)</a>|

---


## 私募指数

> 接口

**/api/v1.2/index/S00000,S00001,S00002,S00003,S00004,S00005,S00006,S00007**

> 方法
* GET

> 输入参数

| 编号 | 说明     |
| :------------- | :------------- |
| S00000       | 全市场|
| S00001       | 中性策略|
| S00002       |股票多头|
| S00003       |期货策略|
| S00004       |债券策略|
| S00005       |混合策略|
| S00006       |组合基金|
| S00007       |其他|

> 输出参数

| 编号 | 说明     |
| :------------- | :------------- |
| data           | 全市场估值       |
---
