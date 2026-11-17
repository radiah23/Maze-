# Recursive Maze Solver (Java)

**Finds a path from start to finish through a grid maze using recursive backtracking, and marks every square as part of the path or a dead end.**

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![Algorithms](https://img.shields.io/badge/topic-recursion%20%26%20backtracking-blue)

Built for the Data Structures course at Smith College.

---

## The problem

Given a maze of walls and open squares, can the finish `F` be reached from the start `S` by moving one square at a time north, south, east or west? If yes, which squares form the path?

## Algorithm

`Maze.solve(location)` is a depth-first search written as recursive backtracking:

1. **Success**: if the current square is the finish, mark it `PATH` and return `true`.
2. **Failure**: if the square is off the grid, a wall, or already visited, return `false`.
3. **Explore**: mark the square `VISITED`, then try the four neighbors in order (North → East → West → South), combining the results with `||` so the search stops at the first route found.
4. **Backtrack**: on the way back out, mark the square `PATH` if any neighbor succeeded, otherwise `DEAD_END`.

When the recursion finishes, the grid shows the solution path and every dead end that was explored. The search visits each square at most once, so it runs in O(rows × columns) time.

## Files

| File | Purpose |
|---|---|
| `Maze.java` | Maze grid, `isExplorable` bounds/wall/visited checks, the recursive `solve` method, and a built-in 10 × 8 demo maze |
| `DisplayableMaze.java` | Interface the maze implements so it can be drawn by a display class |
| `SolveMaze.java` | Entry point: builds the maze and solves it from the start square |

## Running it

```bash
javac *.java
java SolveMaze
```

> **Note:** the course provided the `MazeContents` and `MazeLocation` types and a display class. They are not in this repo, so add them to the same folder before compiling.

## Concepts practiced

Recursion · backtracking / depth-first search · base cases vs. recursive case · 2D arrays · implementing an interface

## Author

**Radiah Khan** · [Portfolio](https://radiah23.github.io)
