class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> freq1;
        unordered_map<char, int> freq2;

        for (const char& c : s) {
            freq1[c]++;
        }

        for (const char& c : t) {
            freq2[c]++;
        }

        return freq1 == freq2;
    }
};
