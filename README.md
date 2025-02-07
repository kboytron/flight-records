# Flight Query System

This project is a Java-based application designed to query and analyze large datasets of flight records. It demonstrates advanced use of data structures, algorithms, and software design patterns to build efficient, scalable, and reusable code.

Built over multiple phases, each assignment builds on the other, showcasing skills in data manipulation, algorithm optimization, and software abstraction.

## Highlights of the Project
1. **Query Optimization:** The system processes and answers complex queries about airline flight data, such as:
   - Identifying unique destinations from a given origin.
   - Finding routes with specific constraints (e.g., two-leg routes).
   - Determining the busiest routes or states based on flight traffic.

2. **Advanced Data Structures:** Efficient use of Java's Maps, Sets, and Lists, including both TreeMap and HashMap implementations, highlights a deep understanding of key-based lookups and sorting.

3. **Custom Algorithms:** Incorporation of multiple algorithmic approaches (e.g., nested loops, sort-and-merge, and map-based querying) demonstrates a strong command over time complexity trade-offs.

4. **Declarative Abstraction:** Queries have been refactored to use a declarative approach, eliminating explicit loops and if-statements. Common operations like Filter, Transform, and Distinct simplify the logic, inspired by real database query languages like SQL.

5. **Caching:** Repeated queries are optimized through caching mechanisms, significantly reducing execution times on subsequent runs.

## Technology
- **Language:** Java (version 15+)
- **Libraries:** Commons CSV (for parsing CSV files)
- **Tools:** IntelliJ IDEA, Git
- **Design Concepts:** Declarative programming, caching, abstraction, reusable components

## Project Structure
- `src/`: Java source code for query operations, dataset parsing, and query execution.
- `test/`: Unit tests to verify functionality, efficiency, and correctness of queries and operations.

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/kboytron/flight-records
   ```
2. Open the project in IntelliJ IDEA.
3. Add the `commons-csv-1.8.jar` dependency.
4. Ensure the `flights1990.csv`, `flights2005.csv`, and `flights2020.csv` data files are available.
5. Run the tests to verify setup:
   ```sh
   ./gradlew test
   ```

## Queries and Operations
The system supports a variety of operations and queries:
- **Filter:** Filters records based on specified conditions.
- **Transform:** Converts records to other formats.
- **Distinct:** Removes duplicate records.
- **Count:** Counts elements in a collection.
- **MapJoin:** Joins two datasets based on shared keys.
- **Cache:** Optimizes performance by storing query results.

## Improvements & Extensions
- Implement additional queries using the existing operations.
- Explore further optimizations in data access patterns and algorithm complexity.
- Enhance the caching mechanism for distributed environments.

## License
This project is for educational purposes. Modify and use it freely for learning.
