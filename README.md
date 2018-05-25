# IMS-进销存管理系统
基于Java实现的InventoryManagementSystem进销存管理系统。

## 进销存管理系统

进销存管理系统（Inventory Management System）

- 进货管理（purchase）
  - **进货入库（purchaseIn）：表单**
  - **入库记录（purchaseRecord）：表格**
- 销售管理（sales）
  - **销售出库（salesOut）：表单，delete**
  - **出库记录（salesRecord）：表格**
- 库存管理（inventory ）
  - **查询库存（InventoryQuery）：表单**
  - **商品管理（InventoryMng）**：表格，update
- 统计报表（statistics）
  - **商品采购统计（statisticsPurchasePanel）**：统计图
  - **商品销售统计（statisticsSalesPanel）**：统计图

## FES

MVC项目架构：

- Model：数据模型层
- View：视图层
- Controller：控制层

```
  View：UI层
    ↑
Controller：控制层调用业务逻辑
    ↑
 Service：业务逻辑， 处理异常
    ↑
   DAO：底层实现
    ↑
   DB：数据库
```

窗口：JFrame

面板：JPanel

对话框：JDialog

表格：JTable

## GUI

```
           
           OperationPanel
           		↑
           SidebarPanel-1+SidebarPanel-2+SidebarPanel-3...
                ↑
MenuPanel + SidebarPanel
   ↑
MainFrame
```



## 数据库设计

用户表user：id，username，password(md5)；

库存表product：proId，proName，dirId，supplier，brand，count

库存分类表productDir：dirId，dirName

记录表purchaseRecord：date，proId，proName，count，register，recordType

## 功能操作

进货入库：

- 插入，库存表product；proId，proName，dirId，supplier，brand，count，register
- 插入，入库记录表；datetime，proId，proName，count

入库记录：

- 查询，入库记录表；

销售出库：

- 删除，库存表product；proId，proName；
- 插入，出库记录表；datetime，proId，proName，count

出库记录：

- 查询，出库记录表；

查询库存：

- 查询byProName，
- 查询All
- 查询by库存不足
- 查询by库存过多

商品管理：

- 更新proName
- 更新dirId
- 更新supplier，
- 更新brand



