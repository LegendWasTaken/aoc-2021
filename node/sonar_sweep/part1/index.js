const fs = require('fs');

const depths = fs.readFileSync("../../../assets/depths.txt", "utf8").split("\n").map(num => Number.parseInt(num));
let larger = 0;
let depth = depths.shift();
depths.forEach(it_depth => {
    if (it_depth > depth)
        larger++;
    depth = it_depth;
});
console.log(larger);