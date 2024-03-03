import React, { useState, useEffect } from 'react';
import axios from 'axios';
import RouteTable from './RouteTable';

const FetchRoutes = () => {
    const [routes, setRoutes] = useState([]);

    useEffect(() => {
        const fetchRoutes = async () => {
            try {
                const response = await axios.get('/api/routes'); // Assuming your routes API endpoint is '/api/routes'
                setRoutes(response.data);
            } catch (error) {
                console.error('Error fetching routes:', error);
            }
        };

        fetchRoutes();
    }, []);

    return (
        <div>
            <h2>Routes</h2>
            <RouteTable routes={routes} />
        </div>
    );
};

export default FetchRoutes;
