#include <vector>
#include <cstdint>
#include <iostream>
#include <array>
#include <fstream>
#include <optional>
#include <numeric>

[[nodiscard]]
std::vector<std::uint64_t> depth_measurements() {
    auto measurements = std::vector<std::uint64_t>();
    auto file = std::ifstream("./assets/depths.txt");
    if (file.is_open()) {
        auto line = std::string();
        while (std::getline(file, line))
            measurements.push_back(std::stoull(line));
    }

    return measurements;
}

int main()
{
    const auto depths = depth_measurements();

    auto larger = 0;
    auto previous = depths[0] + depths[1] + depths[2];
    for (std::uint64_t i = 3; i < depths.size(); ++i) {
        auto sum = std::accumulate(depths.begin() + i - 2, depths.begin() + i, std::uint64_t(0));
        if (sum > previous)
            larger++;
        std::swap(sum, previous);
    }

    std::cout << larger << std::endl;

}