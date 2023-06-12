### Problem

- In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
- If the town judge exists, then:

  - The town judge trusts nobody.
  - Everybody (except for the town judge) trusts the town judge.
  - There is exactly one person that satisfies properties 1 and 2.
  - You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a  
    trust relationship does not exist in trust array, then such a trust relationship does not exist.

- Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

```
Example 1:
    Input: n = 2, trust = [[1,2]]
    Output: 2

Example 2:
    Input: n = 3, trust = [[1,3],[2,3]]
    Output: 3

Example 3:
    Input: n = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1

Constraints:
    1 <= n <= 1000
    0 <= trust.length <= 104
    trust[i].length == 2
    All the pairs of trust are unique.
    ai != bi
    1 <= ai, bi <= n
```

### Approach

- Let’s treat the given scenario as a directed graph in which an edge from person a to b shows that a trusts b.
- A town judge does not trust anybody thus, town judge has no outgoing edge.
- All other n-1 persons trust town judge thus, total n-1 incoming edge towards town judge from all other person.
- So, difference between number of incoming edges and number of outgoing edges is n-1 for town judge only.
- If there is no town judge then no person can achieve the n-1 difference between number of incoming and outgoing edges.

### Solution

- Calculate number of incoming edges – number of outgoing edges for each person. We will do so by traversing the trust array row-wise.
- In any row, there are two elements. Left element is who trusts and right element is whom the left element trusts.
- Thus left element has outgoing edge to right element. Hence, difference value for left element will decrease by 1 and for right element, increase by 1.
- In our code, we have used netTrustGains array for this task. Each index i of this array shows the difference value for ith person.
- After traversing trust array, we will run a loop for each person from 1 to n and check if any person has the difference value = n-1.
- If such a person is found then we will return him else we will return -1.

### code

```java
/**
 * @param n maxValue
 * @param trust two dimensional array input
 * @return
 */
public static int findJudge(int n, int[][] trust) {
        int[] netTrustGains = new int[n + 1];
        for (int[] i : trust) {
            netTrustGains[i[0]]--;
            netTrustGains[i[1]]++;
        }
        //Arrays.stream(netTrustGains).forEach(System.out::println);
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (netTrustGains[i] == n - 1) {
                judge = i;
            }
        }
        return judge;
    }
```
