# Storch Polars: A Scala 3 Interface to Rust Polars

## Overview
Storch Polars is a Scala 3 library that offers a seamless interface to Rust Polars. It enables efficient DataFrame operations and supports interoperability with Python and Rust. The library allows reading from and writing to various file formats, including Avro, IPC, Arrow, Parquet, CSV, DB, Excel, ODS, NPZ, NPY, PKL, PT, PTH, and HDF5. Additionally, it provides common DataFrame functions with plans for more features in the future.

## Features
- **Cross - language Compatibility**: Interact with Python and Rust for DataFrame - related tasks.
- **Extensive File Format Support**: Read and write data in multiple formats such as Avro, IPC, Arrow, Parquet, CSV, DB, Excel, ODS, NPZ, NPY, PKL, PT, PTH, and HDF5.
- **Common DataFrame Operations**: Perform typical DataFrame operations like selection, filtering, sorting, and aggregation.

## Installation
### Prerequisites
- Scala 3.x
- Rust (compatible with Polars)
- Java (if required for the Scala environment)

### SBT
Add the following to your `build.sbt` file:
```scala
libraryDependencies += "io.github.mullerhai" % "storch-polars_3" % "0.1.2"

```

```scala 3
import torch.polars.Polars
import torch.polars.api.DataFrame

object ReadCSVExample {
  def main(args: Array[String]): Unit = {
    val filePath = "path/to/your/file.csv"
    val df: DataFrame = Polars.scan.csv(filePath).collect()
    df.show()
  }
}

```

```scala 3
import torch.polars.Polars
import torch.polars.api.DataFrame

object WriteParquetExample {
  def main(args: Array[String]): Unit = {
    val df: DataFrame = // Assume we have a DataFrame
    val outputPath = "path/to/output.parquet"
    df.write.parquet(outputPath)
  }
}

```


```scala 3

import torch.polars.Polars
import torch.polars.functions._

object DataFrameOperationsExample {
  def main(args: Array[String]): Unit = {
    val df: DataFrame = // Assume we have a DataFrame
    val newDf = df.select(col("column1"), col("column2"))
                 .filter(col("column1") > lit(10))
                 .sort(col("column2"))
    newDf.show()
  }
}
```

## Contributing
We welcome contributions! If you want to contribute to Storch Polars, follow these steps:

Fork the repository.
Create a new branch for your feature or bug - fix.
Make your changes and write tests if applicable.
Submit a pull request.

## License
This project is licensed under the [License Name] license. See the LICENSE file for details.


## more things
original base repo https://github.com/chitralverma/scala-polars