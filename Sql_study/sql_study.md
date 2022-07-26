# Sql Study

[toc]

## 等于

### 例题

**写一个查询语句，返回一个客户列表，列表中客户的推荐人的编号都 不是 2**

给定表 customer ，里面保存了所有客户信息和他们的推荐人。

| id   | name | referee_id|
| ----------- | ------- | ------- |
|    1 | Will |      NULL |
|    2 | Jane |      NULL |
|    3 | Alex |         2 |
|    4 | Bill |      NULL |
|    5 | Zack |         1 |
|    6 | Mark |         2 |


对于上面的示例数据，结果为：

| name |
| ----------- |
| Will |
| Jane |
| Bill |
| Zack |

### 题解

```sql
# 错误解法
select
    name
from customer
where id !=2
```

- = 或 ！= 只能判断基本数据类型 

```sql
# 正确解法
# 先查出推荐人编号为2的有哪些
# 然后使用not in 去剔除这些数据
select
    name
from customer
where id not in (
    select
        id
    from customer
    where referee_id = 2
)

# 正确解法2
# 使用ifNull对推荐人编号进行判断，为null则他的值为0
select
    name
from customer
where ifnull(referee_id,0)!=2;
```

## union关键字

### union的用法

- `union`用来连接两个查询语句，把两个查询语句的查询结果合并起来，两个查询语句的查询字段个数必须一样，否则会出错
- 查询的字段可以不一样，类型也可以不一样，但是这样查询的意义不大，如果查询的字段不一样，最终的结果集以前者查询的字段为准。
- 如果用``union``进行连接，碰到所有字段值一样的列，就会合并，去掉重复的行
- 如果用`union all`进行连接，则不会去掉重复的内容，所有的内容都被取出

### 例题

**请你重构 Products 表，查询每个产品在不同商店的价格，使得输出的格式变为`(product_id, store, price)` 。如果这一产品在商店里没有出售，则不输出这一行。**

输出结果表中的 顺序不作要求 。

表：Products

| Column Name | Type    |
| ----------- | ------- |
| product_id  | int     |
| store1      | int     |
| store2      | int     |
| store3      | int     |

- 这张表的主键是product_id（产品Id）。
  每行存储了这一产品在不同商店store1, store2, store3的价格。
  如果这一产品在商店里没有出售，则值将为null。

示例 1：

**输入：**
Products table:

| product_id | store1 | store2 | store3 |
| ----------- | ------- | ------- | ------- |
| 0          | 95     | 100    | 105    |
| 1          | 70     | null   | 80     |

**输出示例**：

| product_id | store  | price |
| ----------- | ------- | ------- |
| 0          | store1 | 95    |
| 0          | store2 | 100   |
| 0          | store3 | 105   |
| 1          | store1 | 70    |
| 1          | store3 | 80    |

**解释：**
产品0在store1，store2,store3的价格分别为95,100,105。
产品1在store1，store3的价格分别为70,80。在store2无法买到。

```sql
# 解法1
select
    product_id,
    'store1' as store,
    store1 as price
from
    Products
where
    store1 is not null
union all
select
    product_id,
    'store2' as store,
    store2 as price
from
    Products
where
    store2 is not null
union all
select
    product_id,
    'store3' as store,
    store3 as price
from
    Products
where
    store3 is not null
```

## not in和null

### 例题1

**写一个查询语句，输出所有节点的编号和节点的类型，并将结果按照节点编号排序。**

给定一个表 tree，id 是树节点的编号， p_id 是它父节点的 id 。


| id | p_id |
| ----------- | ------- |
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |

树中每个节点属于以下三种类型之一：

叶子：如果这个节点没有任何孩子节点。
根：如果这个节点是整棵树的根，即没有父节点。
内部节点：如果这个节点既不是叶子节点也不是根节点。

**答案示例**


| id | Type |
| ----------- | ------- |
| 1  | Root |
| 2  | Inner|
| 3  | Leaf |
| 4  | Leaf |
| 5  | Leaf |

**解释**

- 节点 '1' 是根节点，因为它的父节点是 NULL ，同时它有孩子节点 '2' 和 '3' 。

- 节点 '2' 是内部节点，因为它有父节点 '1' ，也有孩子节点 '4' 和 '5' 。

- 节点 '3', '4' 和 '5' 都是叶子节点，因为它们都有父节点同时没有孩子节点。

  样例中树的形态如下：


	                                          1
	                                        /   \
	                                       2     3
	                                      /       \
	                                     4         5

**注意**

如果树中只有一个节点，你只需要输出它的根属性。

#### 题解

```sql
# 错误答案
select
    id,
    case when p_id is null then "Root"
         when id not in (select p_id from tree) then "Leaf"
         else "Inner"
    end as Type
from
    tree
```
- `A not in B`的原理是拿A表值与B表值做是否不等的比较, 也就是`a != b`. 在sql中, `null`是缺失未知值而不是空值(详情请见[MySQL reference](https://dev.mysql.com/doc/refman/8.0/en/working-with-null.html)).

- 当你判断任意值`a != null`时, 官方说, `"You cannot use arithmetic comparison operators such as =, <, or <> to test for NULL"`, 任何与`null`值的对比都将返回`null`. 因此返回结果为否,这点可以用代码 `select if(1 = null, 'true', 'false')`证实.

- 从上述原理可见, 当询问 `id not in (select p_id from tree)`时, 因为`p_id`有`null`值, 返回结果全为`false`, 于是跳到`else`的结果, 返回值为`inner`. 所以在答案中,`leaf`结果从未彰显,全被`inner`取代.

```sql
# 正确解法
select id,
    case 
        when p_id is null then "Root"
        when id in (select p_id from tree) then "Inner"
        else "Leaf"
    end as Type
from tree
```

### 例题2

某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。

Customers 表：

| Id | Name  |
| ----------- | ------- |
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |

Orders 表：

| Id | CustomerId |
| ----------- | ------- |
| 1  | 3          |
| 2  | 1          |

例如给定上述表格，你的查询应返回：

| Customers |
| ----------- |
| Henry     |
| Max       |

#### 题解

```sql
# 第一种使用not in
select
    c.Name as Customers
from Customers as c
where id not in (
    select CustomerId
    from Orders
)

# 第二种使用not exists
select 
	c.Name as Customers
from Customers c
where not exists(
    select 
    	1 
    from Orders as o 
    where o.CustomerId=c.Id
)

# 第三种使用左连接
select 
	c.Name as Customers
from Customers c
left join Orders as o
on c.Id=o.CustomerId
where o.Id is null
```

**`not exists` 是`exists`的对立面，所以要了解`not exists`的用法，我们首先了解下`exists`、`in`的区别和特点**

- `exists`：强调的是是否返回结果集，不要知道返回什么

  - ```sql
    select name from student where sex = 'm' and mark exists(select 1 from grade where ...)
    ```
  
  - 只要`exists`引导的子句有结果集返回，那么`exists`这个条件就算成立，如果改成`select 2`，这个数字就没有意义。所以`exists`子句不在乎返回什么，而是在乎是不是有结果集返回
  
- 

## 查出第二高的薪水

**编写一个 SQL 查询，获取并返回 Employee 表中第二高的薪水 。如果不存在第二高的薪水，查询应该返回 null 。**

Employee 表：

| Column Name | Type |
| ----------- | ------- |
| id          | int  |
| salary      | int  |

id 是这个表的主键。
表的每一行包含员工的工资信息。

查询结果如下例所示。

示例 1：
输入：

Employee 表：

| id | salary |
| ----------- | ------- |
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
输出：

| SecondHighestSalary |
| ----------- |
| 200                 |

示例 2：

输入：
Employee 表：

| id | salary |
| ----------- | ------- |
| 1  | 100    |

输出：

| SecondHighestSalary |
| ----------- |
| null                |

### 题解

```sql
# Write your MySQL query statement below
select ifNull((
    select distinct salary
    from Employee
    order by salary desc
    limit 1 offset 1),null) as SecondHighestSalary
```

