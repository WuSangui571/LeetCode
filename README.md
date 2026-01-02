# LeetCode 题解仓库（Java / 自用）

这个仓库用来**按日期**记录我刷 LeetCode 的过程：思路、实现、踩坑与复盘。

## 目录结构

仓库根目录下通常是按天划分的文件夹，例如：

- `2025-05-02/`
- `2025-12-31/`
- `2026-01-02/`

同一天的目录可能有两种形态（取决于当时用的项目模板）：

1. **简单结构（直接写源码）**
   - `YYYY-MM-DD/src/Q_<题号>.java`
2. **Maven 结构（标准 Java 工程）**
   - `YYYY-MM-DD/pom.xml`
   - `YYYY-MM-DD/src/main/java/Q_<题号>.java`

> 命名习惯：`Q_<题号>.java`（例如 `Q_21.java`、`Q_961.java`）。

## 环境要求

- Java：建议使用 **JDK 21**（部分 Maven 目录的 `pom.xml` 以 21 为编译目标）
- Maven：可选（仅在 Maven 结构目录中需要）
- IDE：推荐 IntelliJ IDEA（本仓库目录结构主要面向 IDEA 使用习惯）

## 如何运行

### 方式 A：在 IDE 里运行（推荐）

打开某天的目录（或直接打开仓库），找到对应的 `Q_<题号>.java`，运行 `main` 方法即可。

### 方式 B：命令行运行（非 Maven 结构）

在某天目录下执行（示例）：

```bash
javac src/Q_21.java
java -cp src Q_21
```

### 方式 C：命令行编译（Maven 结构）

在某天目录下执行：

```bash
mvn -q -DskipTests package
```

## 说明

- 本仓库重点是「过程记录」，不保证每题都有完整的注释/最优解/最终版。
- 编译产物（如 `target/`、`out/`、`*.class`）已在根目录 `.gitignore` 中统一忽略，避免污染 Git 状态。

