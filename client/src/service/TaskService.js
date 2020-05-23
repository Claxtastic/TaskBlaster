const API_URL = 'http://localhost:8080';
const HEADERS =  {
    'Accept' : 'application/json',
    'Content-Type' : 'application/json;charset=UTF-8'
};

class TaskService {

    async getAllTasks() {
        await fetch(`${API_URL}/tasks`)
            .then(response => response.json())
            .then(data => console.log(data));
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
