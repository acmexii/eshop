import React from 'react';

import URL from 'constants/url';
import { NavLink } from 'react-router-dom';

function EgovLeftNavInform() { 
    const lastSegment = window.parent.location.href.split('/').pop();
    
    if (lastSegment === 'orders'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Order</h2>
                    <ul className="menu4">
                        <li><NavLink to="/order/orders" className={({ isActive }) => (isActive ? "cur" : "")}>Order</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    if (lastSegment === 'inventories'){
        return (
            <div className="nav">
                <div className="inner">
                    <h2>Product</h2>
                    <ul className="menu4">
                        <li><NavLink to="/product/inventories" className={({ isActive }) => (isActive ? "cur" : "")}>Inventory</NavLink></li>
                    </ul>
                </div>
            </div>
        );
    }
    return null;
}

export default React.memo(EgovLeftNavInform);