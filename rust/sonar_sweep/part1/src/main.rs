use std::fs::File;
use std::io::Read;

fn get_depths() -> Vec<i64> {
    let mut f = File::open("../../../assets/depths.txt").expect("File not found");
    let mut contents = String::new();
    f.read_to_string(&mut contents)
        .expect("Something went wrong reading the file");
    let mut depths: Vec<i64> = Vec::new();
    for line in contents.lines() {
        depths.push(line.parse::<i64>().unwrap());
    }

    depths
}

fn main() {
    let depths = get_depths();

    let mut larger = 0;
    let mut depth = depths[0];
    for i in 1..depths.len() {
        let current = depths[i];
        if current > depth {
            larger += 1;
        }
        depth = current;
    }

    println!("{}", larger);
}
