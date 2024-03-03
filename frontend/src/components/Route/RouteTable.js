import React from 'react';
import axios from 'axios';
import TableRow from './TableRow';

class RouteTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            routes: []
        };
    }

    componentDidMount() {
        this.fetchRoutes();
    }

    fetchRoutes = async () => {
        try {
            const response = await axios.get('/api/routes');
            this.setState({ routes: response.data });
        } catch (error) {
            console.error('Error fetching routes:', error);
        }
    };

    render() {
        const { routes } = this.state;

        return (
            <div className="Table">
                <h3>Recent Routes</h3>
                <table>
                    <thead>
                    <tr>
                        <th>Origin</th>
                        <th>Destination</th>
                        <th>Distance</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {routes.map(route => (
                        <TableRow key={route.id} route={route} />
                    ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default RouteTable;
