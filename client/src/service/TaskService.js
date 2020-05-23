import React from 'react';
import Task from '../components/Task/Task';

const API_URL = 'http://localhost:8080';
const HEADERS =  {
    'Accept' : 'application/json',
    'Content-Type' : 'application/json;charset=UTF-8'
};

class TaskService {

    async getAllTasks(removeTask) {
        const responseJson = await (await fetch(`${API_URL}/tasks`)).json();
        var taskComponents = [];
        for (let [key, taskData] of Object.entries(responseJson)) {
            taskComponents[key] = 
                <Task
                    key={key}
                    number={key} 
                    removeTask={removeTask}
                    title={taskData.title}
                    subTasks={taskData.subtasks}
                    dueDate={taskData.dueDate}/>
        }
        return taskComponents;
    }

    // TODO: Add a username to the params
    async postTask(taskJson) {
        const postOptions = {
            method: 'POST',
            headers: HEADERS,          
            body: JSON.stringify(taskJson)
        };
        await fetch(`${API_URL}/addtask`, postOptions)
            .then(response => {
                console.log(response.status);
            });
    }
}

export default new TaskService();
