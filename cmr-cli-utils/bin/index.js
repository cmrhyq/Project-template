const fs = require('fs');
const ora = require('ora');
const chalk = require('chalk');
const Promise = require('bluebird');
const download = Promise.promisify(require('download - git - repo'));
const spinner = ora('正在下载模板…');

/**
 * 从 github 上下载已有的模版
 * @param answers 命令行收集到的交互信息
 * @param dirname 最终生成的项目名
 */
function downloadFn(answers, dirname) {
    const {frame, name = dirname, description = dirname} = answers;
    // 从 github 上找了两个 star 比较多的脚手架模版,一个 react,一个 vue
    let url = 'https://github.com:bodyno/react-starter-kit#master';
    if (frame === 'vue') {
        url = 'https://github.com:Mrminfive/vue-multiple-page#master';
    }
    spinner.start();
    download(url, dirname, {clone: false}).then(() => {
        spinner.stop(); // 关闭 loading 动效
        console.log(chalk.green('download template success'));
        // 重写 package 中的 name、description 等项目信息
        const pkg = process.cwd() + '/${dirname}/package.json';
        const content = JSON.parse(fs.readFileSync(pkg, 'utf8'));
        content.name = name;
        content.description = description;
        const result = JSON.stringify(content);
        fs.writeFileSync(pkg, result);
    }).catch(err => {
        spinner.stop(); // 关闭 loading 动效
        console.log(chalk.red('download template failed'));
        console.log(err);
    });
}
