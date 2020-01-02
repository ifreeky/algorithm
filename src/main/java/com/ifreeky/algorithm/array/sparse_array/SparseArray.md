# 稀疏数组
- 所谓稀疏数组就是当数组中大多数空间未使用或者为0时，为了避免空间浪费，而提出的一种数组压缩方式。
- 假如原来有一个数组，其结构如下

    |   | 0 | 1 | 2 | 3 |4  |5  |6  |
    |---|---|---|---|---|---|---|---|
    | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |
    | 1 | 0 | 0 | 0 | 0 | 0 | 2 | 0 |
    | 2 | 0 | 0 | 6 | 0 | 0 | 0 | 0 |
    | 3 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    | 4 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    | 5 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    | 6 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    
 - 在此数组中，共有 7*7=49 个空间，但只使用了3个空间，造成了46个空间的浪费。
 - 其对应的稀疏数组如下所示
 
    |   | 0 | 1 | 2 | 
    |---|---|---|---|
    | 0 | 7 | 7 | 3 |
    | 1 | 0 | 0 | 1 |
    | 2 | 1 | 5 | 2 |
    | 3 | 2 | 2 | 6 |
   
- 在稀疏数组中，各个空间代表的值如下
    - `[0][0]`表示数组的行数
    - `[0][1]`表示数组的列数
    - `[0][2]`表示数组有效数字个数
    - 后续每行代表原始数组中的一个值，`[n][m]`代表第`n`个值的行坐标，`[n][m+1]`代表`n`的列坐标，`[n][m+2]`代表`n`的值。`(n > 0, m >= 0)`