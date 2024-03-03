import React from 'react';

class TableRow extends React.Component {
    render() {
        const { route } = this.props;

        return (
            <tr>
                <td>{route.origin}</td>
                <td>{route.destination}</td>
                <td>{route.distance}</td>
                <td>{route.status}</td>
                <td>
                    <button>Edit</button>
                    <button>Delete</button>
                </td>
            </tr>
        );
    }
}

export default TableRow;
