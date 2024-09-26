import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    stages: [
        {
            duration: '1m',
            target: 50
        },
        {
            duration: '1m',
            target: 100
        },
        {
            duration: '1m',
            target: 150
        },
        {
            duration: '1m',
            target: 200
        },
        {
            duration: '1m',
            target: 200
        }
    ]
};

export default function () {
    const url = 'http://localhost:8081/attendances/0053449e-f8e0-42e7-ada3-5c510516e499';
    http.get(url, null);
    sleep(0.5);
}