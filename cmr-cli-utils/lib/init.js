var inquirer = require('inquirer');

function inquirerFn() {
    return inquirer.prompt([
        {
            type: 'list',
            name: 'frame',
            message: '请选择开发用的脚手架:',
            choices: ['react', 'vue']
        },
        {
            type: 'input',
            name: 'name',
            message: '请输入项目名称:'
        },
        {
            type: 'input',
            name: 'description',
            message: '请输入项目简介:'
        }
    ]);
}
