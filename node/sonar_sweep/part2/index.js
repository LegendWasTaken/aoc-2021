const fs = require('fs');

const depths = fs.readFileSync("../../../assets/depths.txt", "utf8").split("\n").map(num => Number.parseInt(num));
let larger = 0;
let previous = depths.slice(0, 2).reduce((a, b) => a + b, 0);
for (let i = 3; i <depths.length; i++) {
    let sum = depths.slice(i - 2, i).reduce((a, b) => a + b, 0);
    if (sum > previous)
        larger++;
    previous = sum;
}
console.log(larger);