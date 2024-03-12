#include <iostream>
#include <vector>
#include <string>

int main() {
    int n;
    std::cin >> n;
    std::vector<int> nums(n);
    for (int i = 0; i < n; i++) {
        std::cin >> nums[i];
        nums[i] = (nums[i] % 2 == 0) ? 0 : 1;
    }
    std::string res = "";
    int current = nums[0];
    for (int i = 1; i < n; i++) {
        if ((nums[i] == 0 && current == 1) || (nums[i] == 1 && current == 0)) {
            current = 1;
            res += "+";
        } else if (nums[i] == 1 && current == 1) {
            res += "x";
        } else {
            current = 0;
            res += "+";
        }
    }
    std::cout << res << std::endl;
    return 0;
}