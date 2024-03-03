import React, { useState } from "react";
import "./Sidebar.css";
import Logo from "../../imgs/logo.png";
import { UilSignOutAlt } from "@iconscout/react-unicons";
import { SidebarData } from "../../Data/Data";
import { UilBars } from "@iconscout/react-unicons";
import { motion } from "framer-motion";
import { Link } from "react-router-dom"; // Import Link from react-router-dom

const Sidebar = () => {
    const [selected, setSelected] = useState(0);
    const [expanded, setExpanded] = useState(true);

    const sidebarVariants = {
        true: { left: '0' },
        false: { left: '-60%' }
    };

    const toggleSidebar = () => {
        setExpanded(!expanded);
    };

    return (
        <>
            <div
                className="bars"
                style={expanded ? { left: '60%' } : { left: '5%' }}
                onClick={toggleSidebar}
            >
                <UilBars />
            </div>
            <motion.div
                className='sidebar'
                variants={sidebarVariants}
                animate={window.innerWidth <= 768 ? (expanded ? 'true' : 'false') : ''}
            >
                <div className="logo">
                    <img src={Logo} alt="logo" />
                    <span>
            Bus<span> Net</span>
          </span>
                </div>
                <div className="menu">
                    {SidebarData.map((item, index) => (
                        <Link
                            key={index}
                            to={item.path} // Use the 'to' prop to specify the route path
                            className={selected === index ? "menuItem active" : "menuItem"}
                            onClick={() => setSelected(index)}
                        >
                            <item.icon />
                            <span>{item.heading}</span>
                        </Link>
                    ))}
                    <div className="menuItem">
                        <UilSignOutAlt />
                    </div>
                </div>
            </motion.div>
        </>
    );
};
export default Sidebar;
