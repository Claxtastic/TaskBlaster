import axios from 'axios';

const API_URL = 'http://localhost:8080';
const TASK_API_URL = `${API_URL}/tasks`;

class TaskService {

    retrieveAllTasks() {
        return axios.get(TASK_API_URL);
    }
}

export default new TaskService();
