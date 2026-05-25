class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        s_d = {}
        t_d = {}

        for c in s:
            s_d[c] = s_d.get(c, 0) + 1

        for c in t:
            t_d[c] = t_d.get(c, 0) + 1

        return s_d == t_d
