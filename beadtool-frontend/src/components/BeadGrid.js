import React from 'react'; 
import palette from '../palettes/mard.json';
const colorMap = {};
palette.forEach(c => {
  const [r, g, b] = c.rgb;
  colorMap[c.name] = `rgb(${r}, ${g}, ${b})`;
});
//grid is the prop 
function BeadGrid({grid}){
    const cellSize = 20;

  return (
    <div
      style={{
        display: 'grid',
        gridTemplateColumns: `repeat(${grid[0].length}, ${cellSize}px)`,
        gap: '1px',
        marginTop: '20px',
      }}
    >
      {grid.map((row, rowIndex) =>
        row.map((cell, colIndex) => (
          <div
            key={`${rowIndex}-${colIndex}`}
            style={{
              
        
              width: `${cellSize}px`,
              height: `${cellSize}px`,
              backgroundColor: colorMap[cell] || '#ccc',
              border: '1px solid #ddd',
              fontSize: '8px',
              color: '#000',
              textAlign: 'center',
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
            }}
           // Tooltip on hover
          >
            {/* Show first 2 chars of color label for readability */}
            {cell.slice(0, 2)}
          </div>
        ))
      )}
    </div>
  );
    
}

export default BeadGrid; 