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

    auto depth = depths[0];
    auto larger = std::count_if(depths.begin() + 1, depths.end(), [&depth](auto d) {
        depth = d;
        return d > depth;
    });

    std::cout << larger << std::endl;
}