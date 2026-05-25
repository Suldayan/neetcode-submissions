#include <unordered_map>
using namespace std;

class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_map<int, int> frequency;

        for (int num : nums) {
            frequency[num]++;
            if (frequency[num] > 1) {
                return true;   
            }
        }

        return false; 
    }
};
