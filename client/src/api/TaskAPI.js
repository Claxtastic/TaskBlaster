import React from 'react';
import Task from '../components/Task';

const API_URL = 'http://localhost:8080';
const HEADERS =  {
    'Accept' : 'application/json',
    'Content-Type' : 'application/json;charset=UTF-8'
};

class TaskAPI {

    async getAllTasks(removeTask) {
        const responseJson = await (await fetch(`${API_URL}/tasks`)).json();
        var taskComponents = [];
        for (let [key, taskData] of Object.entries(responseJson)) {
            taskComponents[key] = 
                <Task
                    key={taskData.id}
                    number={taskData.id} 
                    removeTask={removeTask}
                    title={taskData.title}
                    subTasks={taskData.subTasks}
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
        const response = await fetch(`${API_URL}/addtask`, postOptions);
        console.log(`POST: ${response.status}`);
        const responseJson = await response.json();
        return responseJson;
    }

    async deleteTask(id) {
        const deleteOptions = {
            method: 'DELETE'
        };
        await fetch(`${API_URL}/delete/${id}`, deleteOptions)
            .then(response => {
                console.log(`DELETE: ${response.status}`);
            });
    }
}

export default new TaskAPI();
